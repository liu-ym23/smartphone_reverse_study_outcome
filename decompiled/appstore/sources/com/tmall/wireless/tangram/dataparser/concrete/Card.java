package com.tmall.wireless.tangram.dataparser.concrete;

import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.FixAreaLayoutHelper;
import com.alibaba.android.vlayout.layout.MarginLayoutHelper;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.Engine;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.TangramBuilder;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.expression.ITangramExprParser;
import com.tmall.wireless.tangram.expression.TangramExpr;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.entitycard.BannerEntityCard;
import com.tmall.wireless.tangram.structure.entitycard.EntityCard;
import com.tmall.wireless.tangram.structure.entitycard.GridEntityCard;
import com.tmall.wireless.tangram.support.CardSupport;
import com.tmall.wireless.tangram.support.ExposureSupport;
import com.tmall.wireless.tangram.util.ImageUtils;
import com.tmall.wireless.tangram.util.LogUtils;
import com.tmall.wireless.tangram.util.Preconditions;
import com.tmall.wireless.tangram.util.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.channels.Channel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Card extends ComponentLifecycle implements ITangramExprParser {
    public static final String KEY_API_LOAD = "load";
    public static final String KEY_API_LOAD_PARAMS = "loadParams";
    public static final String KEY_FOOTER = "footer";
    public static final String KEY_HAS_MORE = "hasMore";
    public static final String KEY_HEADER = "header";
    public static final String KEY_ID = "id";
    public static final String KEY_ITEMS = "items";
    public static final String KEY_LOADED = "loaded";
    public static final String KEY_LOAD_TYPE = "loadType";
    public static final String KEY_MAX_CHILDREN = "maxChildren";
    public static final String KEY_STYLE = "style";
    public static final String KEY_TYPE = "type";
    public static final int LOAD_TYPE_LOADMORE = 1;
    private static final String TAG = "Card";
    public JSONObject extras;
    public boolean hasMore;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @Nullable
    public String f18212id;
    public String load;
    public boolean loadMore;
    public JSONObject loadParams;
    public boolean loaded;
    public boolean loading;

    @NonNull
    protected List<BaseCell> mCells;

    @Nullable
    protected BaseCell mFooter;

    @Nullable
    protected BaseCell mHeader;

    @NonNull
    protected final List<BaseCell> mInQueueCells;
    private boolean mIsExposed;
    private LayoutHelper mLayoutHelper;

    @Nullable
    private Map<String, Object> mParams;

    @NonNull
    protected final List<BaseCell> mPendingCells;
    private BaseCell mPlaceholderCell;
    private boolean mPlaceholderRequired;
    protected boolean mRetainLayout;
    private float mTmpAspectRatio;
    protected int maxChildren;
    private final SparseArray<BaseCell> newMap;
    private final SparseArray<BaseCell> oldMap;
    public int page;
    private final SparseBooleanArray pendingDeleteMap;
    public int rowId;

    @Nullable
    protected ServiceManager serviceManager;

    @Nullable
    public Style style;
    public int type;

    public static class BindListener implements BaseLayoutHelper.LayoutViewBindListener {
        private Style mStyle;

        public BindListener(Style r10) {
            this.mStyle = r10;
        }

        @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper.LayoutViewBindListener
        public void onBind(View r10, BaseLayoutHelper r11) {
            Style r12 = this.mStyle;
            if (r12 != null) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r12.bgImgUrl) == false) goto L7;
            return;
        L7:
            if ((r10 instanceof ImageView) == false) goto L12;
            ImageUtils.doLoadImageUrl((ImageView) r10, this.mStyle.bgImgUrl);
            return;
        }
    }

    public static class CellPositionComparator implements Comparator<BaseCell> {
        public static final CellPositionComparator COMPARATOR = null;
        public static final CellPositionComparator REVERSE_COMPARATOR = null;
        private int mLarge;
        private int mSmall;

        static {
            COMPARATOR = new CellPositionComparator(false);
            REVERSE_COMPARATOR = new CellPositionComparator(true);
        }

        public CellPositionComparator(boolean r10) {
            if (r10 == false) goto L5;
            int r11 = -1;
        L6:
            this.mLarge = r11;
            this.mSmall = -r11;
            return;
        L5:
            r11 = 1;
            goto L6
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(BaseCell r10, BaseCell r11) {
            return compare2(r10, r11);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(BaseCell r10, BaseCell r11) {
            if (r10 != null) goto L6;
            if (r11 != null) goto L6;
            return 0;
        L6:
            if (r10 == null) goto L8;
            if (r11 == null) goto L11;
            int r12 = r10.position;
            int r13 = r11.position;
            if (r12 < r13) goto L19;
            if (r12 != r13) goto L18;
            return 0;
        L18:
            return this.mLarge;
        L19:
            return this.mSmall;
        L11:
            return this.mLarge;
        L8:
            return this.mSmall;
        }
    }

    public static final class PlaceholderCell extends BaseCell {
        private int mBgColor;
        private int mHeight;
        private View mPlaceholderView;

        public PlaceholderCell(int r10, int r11) {
            this(r10, null, r11);
        }

        @Override // com.tmall.wireless.tangram.structure.BaseCell
        public void bindView(@NonNull View r10) {
            View r11 = this.mPlaceholderView;
            if (r11 != null) goto L5;
            return;
        L5:
            if ((r10 instanceof FrameLayout) == true) goto L7;
            return;
        L7:
            if ((r11.getParent() instanceof FrameLayout) == false) goto L9;
            ((FrameLayout) this.mPlaceholderView.getParent()).removeView(this.mPlaceholderView);
        L9:
            ((FrameLayout) r10).addView(this.mPlaceholderView);
        }

        public PlaceholderCell(int r10, View r11) {
            this(r10, r11, 0);
        }

        public PlaceholderCell(int r10, View r11, int r12) {
            this.mHeight = r10;
            this.mPlaceholderView = r11;
            this.mBgColor = r12;
            Style r13 = new Style();
            this.style = r13;
            r13.height = this.mHeight;
            r13.bgColor = this.mBgColor;
            r13.extras = new JSONObject();
            this.style.extras.put("display", "block");     // Catch: JSONException -> L5
        L7:
            this.type = -1;
            return;
        L5:
            e = move-exception;
            i.l(Card.TAG, i.d(e), e);
            goto L7
        }
    }

    public static class UnbindListener implements BaseLayoutHelper.LayoutViewUnBindListener {
        private Style mStyle;

        public UnbindListener(Style r10) {
            this.mStyle = r10;
        }

        @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper.LayoutViewUnBindListener
        public void onUnbind(View r10, BaseLayoutHelper r11) {
        }
    }

    public Card() {
        this.mCells = new ArrayList();
        this.mPendingCells = new ArrayList();
        this.mInQueueCells = new ArrayList();
        this.loadMore = false;
        this.loading = false;
        this.loaded = false;
        this.hasMore = false;
        this.maxChildren = Channel.UNLIMITED;
        this.extras = new JSONObject();
        this.mLayoutHelper = null;
        this.mRetainLayout = true;
        this.mIsExposed = false;
        this.pendingDeleteMap = new SparseBooleanArray();
        this.oldMap = new SparseArray();
        this.newMap = new SparseArray();
        this.mTmpAspectRatio = Float.NaN;
        this.mPlaceholderRequired = true;
    }

    private boolean addCellInternal(@Nullable BaseCell r10, boolean r11) {
        if (r10 == null) goto L26;
        r10.parentId = this.f18212id;
        r10.parent = this;
        r10.serviceManager = this.serviceManager;
        MVHelper r12 = getMVHelper();
        if (r12 != null) goto L6;
        return false;
    L6:
        if (r12.isValid(r10, this.serviceManager) == true) goto L8;
        return false;
    L8:
        if (r10.position < 0) goto L14;
        if (TextUtils.isEmpty(this.load) == true) goto L14;
        r10.pos = r10.position;
        this.mPendingCells.add(r10);
        return true;
    L14:
        if (this.mHeader == null) goto L16;
        int r13 = this.mCells.size() + 1;
    L17:
        r10.pos = r13;
        if (r11 == false) goto L20;
    L22:
        this.mCells.add(r10);
        BaseCell r14 = this.mFooter;
        if (r14 == null) goto L25;
        r14.pos = r10.pos + 1;
    L25:
        return true;
    L20:
        if (this.mIsActivated == false) goto L22;
        r10.added();
        goto L22
    L16:
        r13 = this.mCells.size();
        goto L17
    L26:
        return false;
    }

    private void adjustPendingCells(boolean r10) {
        if (this.mPendingCells.size() <= 0) goto L16;
        Collections.sort(this.mPendingCells, CellPositionComparator.COMPARATOR);
        Iterator<BaseCell> r11 = this.mPendingCells.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        BaseCell r12 = r11.next();
        int r13 = r12.position;
        if (r13 < 0) goto L6;
        if (r13 >= this.mCells.size()) goto L16;
        this.mCells.add(r12.position, r12);
        this.mInQueueCells.add(r12);
        r11.remove();
        if (r10 == true) goto L6;
        r12.added();
    L16:
        if (this.mInQueueCells.size() <= 0) goto L27;
        Collections.sort(this.mInQueueCells, CellPositionComparator.REVERSE_COMPARATOR);
        Iterator<BaseCell> r14 = this.mInQueueCells.iterator();
    L19:
        if (r14.hasNext() == false) goto L27;
        BaseCell r15 = r14.next();
        int r16 = r15.position;
        if (r16 < 0) goto L19;
        if (r16 <= this.mCells.size()) goto L27;
        this.mPendingCells.add(r15);
        r14.remove();
    L27:
        if (TangramBuilder.isPrintLog() == true) goto L29;
        return;
    L29:
        if (this.mPendingCells.size() > 0) goto L31;
        return;
    L31:
        if (this.mInQueueCells.size() <= 0) goto L53;
        boolean r17 = false;
        int r18 = this.mPendingCells.get(0).position;
        List<BaseCell> r19 = this.mInQueueCells;
        if (r18 < r19.get(r19.size() - 1).position) goto L35;
        r17 = true;
    L35:
        Preconditions.checkState(r17, "Items in pendingQueue must have large position than Items in queue");
        return;
    }

    private void diffCells(@NonNull SparseArray<BaseCell> r10, @NonNull SparseArray<BaseCell> r11) {
        if (this.mIsActivated == true) goto L5;
        return;
    L5:
        int r12 = r10.size();
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L11;
        BaseCell r15 = r10.get(r10.keyAt(r14));
        if (r15 == null) goto L10;
        r15.added();
    L10:
        r14 = r14 + 1;
        goto L6
    L11:
        int r16 = r11.size();
    L12:
        if (r13 >= r16) goto L17;
        BaseCell r17 = r11.get(r11.keyAt(r13));
        if (r17 == null) goto L16;
        r17.removed();
    L16:
        r13 = r13 + 1;
        goto L12
    }

    private MVHelper getMVHelper() {
        ServiceManager r10 = this.serviceManager;
        if (r10 != null) goto L5;
        return null;
    L5:
        return (MVHelper) r10.getService(MVHelper.class);
    }

    public void addCell(@Nullable BaseCell r10) {
        addCellInternal(r10, false);
        adjustPendingCells(false);
        BaseCell r11 = this.mPlaceholderCell;
        if (r11 == null) goto L8;
        if (this.mCells.contains(r11) == false) goto L8;
        this.mCells.remove(this.mPlaceholderCell);
    L8:
        if (requirePlaceholderCell() == false) goto L11;
        this.mCells.add(this.mPlaceholderCell);
        return;
    }

    public void addCells(@Nullable List<BaseCell> r10) {
        if (r10 == null) goto L8;
        Iterator<BaseCell> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        addCellInternal(r11.next(), false);
    L8:
        adjustPendingCells(false);
        BaseCell r12 = this.mPlaceholderCell;
        if (r12 == null) goto L14;
        if (this.mCells.contains(r12) == false) goto L14;
        this.mCells.remove(this.mPlaceholderCell);
    L14:
        if (requirePlaceholderCell() == false) goto L18;
        this.mCells.add(this.mPlaceholderCell);
        return;
    }

    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        return null;
    }

    public BaseCell createCell(@NonNull MVHelper r10, @Nullable JSONObject r11, boolean r12) {
        if (r11 == null) goto L39;
        int r13 = r11.optInt("type", -1);
        if (Utils.isCellizedCard(r11) == false) goto L8;
        r13 = Utils.cellizeCard(r13);
    L8:
        if (getMVHelper() == null) goto L39;
        if (getMVHelper().resolver().getViewClass(r13) == null) goto L39;
        if (r10.resolver().isCompatibleType(r13) == false) goto L18;
        BaseCell r14 = (BaseCell) Utils.newInstance(r10.resolver().getCellClass(r13));
        if (r14 != null) goto L16;
        return null;
    L16:
        r14.serviceManager = this.serviceManager;
    L37:
        parseCell(r10, r11, r14, r12);
        r14.type = r13;
        return r14;
    L18:
        if (Utils.isCellizedCard(r11) == false) goto L36;
        int r15 = Utils.cardizeCell(r13);
        if (r15 != 1) goto L22;
    L34:
        BaseCell r16 = new GridEntityCard(r13);
    L32:
        r14 = r16;
        r14.serviceManager = this.serviceManager;
        r14.parent = this;
        r14.parentId = this.f18212id;
        goto L37
    L22:
        if (r15 == 2) goto L34;
        if (r15 == 3) goto L34;
        if (r15 == 4) goto L34;
        if (r15 == 9) goto L34;
        if (r15 == 10) goto L33;
        r16 = new EntityCard(r13);
        goto L32
    L33:
        r16 = new BannerEntityCard();
        goto L32
    L36:
        r14 = new BaseCell(r13);
        r14.serviceManager = this.serviceManager;
        r14.parent = this;
        r14.parentId = this.f18212id;
    L39:
        return null;
    }

    public void enablePlaceholderView(View r10, int r11) {
        if (TextUtils.isEmpty(this.load) == true) goto L8;
        if (r10 == null) goto L8;
        storeAspectRatio();
        this.mPlaceholderCell = new PlaceholderCell(r11, r10);
        if (this.mCells.size() != 0) goto L10;
        this.mCells.add(this.mPlaceholderCell);
        return;
    L10:
        return;
    L8:
        this.mCells.remove(this.mPlaceholderCell);
        this.mPlaceholderCell = null;
    }

    public List<BaseCell> getCells() {
        return this.mCells;
    }

    @Nullable
    public final LayoutHelper getLayoutHelper() {
        LayoutHelper r10 = convertLayoutHelper(this.mLayoutHelper);
        Style r11 = this.style;
        if (r11 == null) goto L36;
        if (r10 == null) goto L36;
        r10.setZIndex(r11.zIndex);
        if ((r10 instanceof BaseLayoutHelper) == false) goto L18;
        BaseLayoutHelper r12 = (BaseLayoutHelper) r10;
        r12.setBgColor(this.style.bgColor);
        ServiceManager r13 = this.serviceManager;
        if (r13 == null) goto L13;
        if (r13.getService(CardSupport.class) == null) goto L13;
        final CardSupport r14 = (CardSupport) this.serviceManager.getService(CardSupport.class);
        final Style r15 = this.style;
        r12.setLayoutViewBindListener(new AnonymousClass1(this, r15, r14));
        final Style r16 = this.style;
        r12.setLayoutViewUnBindListener(new AnonymousClass2(this, r16, r14));
    L16:
        Float.isNaN(this.style.aspectRatio);
    L13:
        if (TextUtils.isEmpty(this.style.bgImgUrl) == true) goto L15;
        r12.setLayoutViewBindListener(new BindListener(this.style));
        r12.setLayoutViewUnBindListener(new UnbindListener(this.style));
        goto L16
    L15:
        r12.setLayoutViewBindListener(null);
        r12.setLayoutViewUnBindListener(null);
    L18:
        if ((r10 instanceof FixAreaLayoutHelper) == false) goto L33;
        FixAreaLayoutHelper r17 = (FixAreaLayoutHelper) r10;
        ServiceManager r18 = this.serviceManager;
        if (r18 != null) goto L22;
    L26:
        JSONObject r19 = this.style.extras;
        if (r19 == null) goto L29;
        final int r20 = r19.optInt(Style.KEY_ANIMATION_DURATION);
    L30:
        if (r20 <= 0) goto L33;
        r17.setFixViewAnimatorHelper(new AnonymousClass3(this, r20));
        goto L33
    L29:
        r20 = 0;
        goto L30
    L22:
        if (r18.getService(CardSupport.class) == null) goto L26;
        FixAreaLayoutHelper.FixViewAnimatorHelper r21 = ((CardSupport) this.serviceManager.getService(CardSupport.class)).onGetFixViewAppearAnimator(this);
        if (r21 == null) goto L26;
        r17.setFixViewAnimatorHelper(r21);
    L33:
        if ((r10 instanceof MarginLayoutHelper) == false) goto L36;
        MarginLayoutHelper r22 = (MarginLayoutHelper) r10;
        int[] r23 = this.style.margin;
        r22.setMargin(r23[3], r23[0], r23[1], r23[2]);
        int[] r24 = this.style.padding;
        r22.setPadding(r24[3], r24[0], r24[1], r24[2]);
    L36:
        if (this.mRetainLayout == false) goto L38;
        this.mLayoutHelper = r10;
    L38:
        return r10;
    }

    @Nullable
    public Map<String, Object> getParams() {
        Map<String, Object> r10 = this.mParams;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Collections.emptyMap();
    }

    public BaseCell getPlaceholderCell() {
        return this.mPlaceholderCell;
    }

    @Override // com.tmall.wireless.tangram.expression.ITangramExprParser
    public Object getValueBy(TangramExpr r10) {
        if (r10.hasNextFragment() == true) goto L14;
    L12:
        return null;
    L14:
        int r11 = Integer.parseInt(r10.nextFragment());     // Catch: NumberFormatException -> L13
        List<BaseCell> r12 = this.mCells;     // Catch: NumberFormatException -> L13
        if (r12 == null) goto L12;
        if (r12.size() <= r11) goto L12;
        if (r11 < 0) goto L12;
        return this.mCells.get(r11).getValueBy(r10);
    }

    public boolean isValid() {
        if (this.type >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.serviceManager == null) goto L7;
        return true;
    }

    public final void notifyDataChange() {
        ServiceManager r10 = this.serviceManager;
        if ((r10 instanceof Engine) == false) goto L6;
        ((Engine) r10).refresh();
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.ComponentLifecycle
    public void onAdded() {
        Iterator<BaseCell> r10 = this.mCells.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().added();
        goto L4
    }

    public void onBindCell(int r10, int r11, boolean r12) {
        if (this.mIsExposed == true) goto L9;
        ServiceManager r13 = this.serviceManager;
        if (r13 == null) goto L9;
        ExposureSupport r14 = (ExposureSupport) r13.getService(ExposureSupport.class);
        if (r14 == null) goto L9;
        this.mIsExposed = true;
        r14.onExposure(this, r10, r11);
    L9:
        if (r10 != 0) goto L16;
        ServiceManager r15 = this.serviceManager;
        if (r15 == null) goto L17;
        ExposureSupport r16 = (ExposureSupport) r15.getService(ExposureSupport.class);
        if (r16 == null) goto L18;
        r16.onExposureReaptly(this, r10, r11);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.ComponentLifecycle
    public void onRemoved() {
        Iterator<BaseCell> r10 = this.mCells.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().removed();
        goto L4
    }

    public boolean optBoolParam(String r10) {
        if (this.extras.has(r10) == true) goto L5;
        Style r11 = this.style;
        if (r11 == null) goto L13;
        JSONObject r12 = r11.extras;
        if (r12 == null) goto L13;
        if (r12.optBoolean(r10) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        return this.extras.optBoolean(r10);
    }

    public double optDoubleParam(String r10) {
        if (this.extras.has(r10) == true) goto L5;
        Style r11 = this.style;
        if (r11 == null) goto L12;
        JSONObject r12 = r11.extras;
        if (r12 != null) goto L11;
        return Double.NaN;
    L11:
        return r12.optDouble(r10);
    L12:
        return Double.NaN;
    L5:
        return this.extras.optDouble(r10);
    }

    public int optIntParam(String r10) {
        if (this.extras.has(r10) == true) goto L5;
        Style r11 = this.style;
        if (r11 == null) goto L12;
        JSONObject r12 = r11.extras;
        if (r12 != null) goto L11;
        return 0;
    L11:
        return r12.optInt(r10);
    L12:
        return 0;
    L5:
        return this.extras.optInt(r10);
    }

    public JSONArray optJsonArrayParam(String r10) {
        if (this.extras.has(r10) == true) goto L5;
        Style r11 = this.style;
        if (r11 == null) goto L12;
        JSONObject r12 = r11.extras;
        if (r12 != null) goto L11;
        return null;
    L11:
        return r12.optJSONArray(r10);
    L12:
        return null;
    L5:
        return this.extras.optJSONArray(r10);
    }

    public JSONObject optJsonObjectParam(String r10) {
        if (this.extras.has(r10) == true) goto L5;
        Style r11 = this.style;
        if (r11 == null) goto L12;
        JSONObject r12 = r11.extras;
        if (r12 != null) goto L11;
        return null;
    L11:
        return r12.optJSONObject(r10);
    L12:
        return null;
    L5:
        return this.extras.optJSONObject(r10);
    }

    public long optLongParam(String r10) {
        if (this.extras.has(r10) == true) goto L5;
        Style r11 = this.style;
        if (r11 == null) goto L12;
        JSONObject r12 = r11.extras;
        if (r12 != null) goto L11;
        return 0;
    L11:
        return r12.optLong(r10);
    L12:
        return 0;
    L5:
        return this.extras.optLong(r10);
    }

    public Object optParam(String r10) {
        if (this.extras.has(r10) == true) goto L5;
        Style r11 = this.style;
        if (r11 == null) goto L12;
        JSONObject r12 = r11.extras;
        if (r12 != null) goto L11;
        return null;
    L11:
        return r12.opt(r10);
    L12:
        return null;
    L5:
        return this.extras.opt(r10);
    }

    public String optStringParam(String r10) {
        if (this.extras.has(r10) == true) goto L5;
        Style r11 = this.style;
        if (r11 == null) goto L12;
        JSONObject r12 = r11.extras;
        if (r12 != null) goto L11;
        return "";
    L11:
        return r12.optString(r10);
    L12:
        return "";
    L5:
        return this.extras.optString(r10);
    }

    public void parseCell(@NonNull MVHelper r10, @NonNull JSONObject r11, @NonNull BaseCell r12, boolean r13) {
        r10.parseCell(r10, r12, r11);
        if (r13 == true) goto L5;
        return;
    L5:
        if (addCellInternal(r12, false) == false) goto L7;
        return;
    L7:
        if (TangramBuilder.isPrintLog() == false) goto L12;
        LogUtils.w(TAG, "Parse invalid cell with data: " + r11.toString());
        return;
    }

    public void parseFooterCell(@NonNull MVHelper r10, @Nullable JSONObject r11) {
    }

    public void parseHeaderCell(@NonNull MVHelper r10, @Nullable JSONObject r11) {
    }

    public void parseStyle(@Nullable JSONObject r10) {
        Style r11 = new Style();
        this.style = r11;
        r11.parseWith(r10);
    }

    public void parseWith(@NonNull JSONObject r10, @NonNull MVHelper r11) {
        if (TangramBuilder.isPrintLog() == true) goto L5;
    L9:
        this.extras = r10;
        this.type = r10.optInt("type", this.type);
        String r12 = this.f18212id;
        if (r12 != null) goto L12;
        r12 = "";
    L12:
        this.f18212id = r10.optString("id", r12);
        int r13 = 0;
        if (r10.optInt(KEY_LOAD_TYPE, 0) != 1) goto L15;
        boolean r14 = true;
    L16:
        this.loadMore = r14;
        if (r10.has(KEY_HAS_MORE) == false) goto L20;
        this.hasMore = r10.optBoolean(KEY_HAS_MORE);
    L26:
        this.load = r10.optString(KEY_API_LOAD, null);
        this.loadParams = r10.optJSONObject(KEY_API_LOAD_PARAMS);
        this.loaded = r10.optBoolean(KEY_LOADED, false);
        this.maxChildren = r10.optInt(KEY_MAX_CHILDREN, this.maxChildren);
        if (Utils.isSupportHeaderFooter(this.type) == false) goto L29;
        parseHeaderCell(r11, r10.optJSONObject("header"));
    L29:
        JSONArray r15 = r10.optJSONArray(KEY_ITEMS);
        if (r15 == null) goto L35;
        int r16 = Math.min(r15.length(), this.maxChildren);
    L32:
        if (r13 >= r16) goto L35;
        createCell(r11, r15.optJSONObject(r13), true);
        r13 = r13 + 1;
    L35:
        if (Utils.isSupportHeaderFooter(this.type) == false) goto L37;
        parseFooterCell(r11, r10.optJSONObject(KEY_FOOTER));
    L37:
        parseStyle(r10.optJSONObject("style"));
        return;
    L20:
        if (r10.has(KEY_LOAD_TYPE) == false) goto L26;
        if (r10.optInt(KEY_LOAD_TYPE) != 1) goto L24;
        boolean r17 = true;
    L25:
        this.hasMore = r17;
        goto L26
    L24:
        r17 = false;
        goto L25
    L15:
        r14 = false;
        goto L16
    L5:
        if (this.serviceManager != null) goto L9;
        throw new RuntimeException("serviceManager is null when parsing card");
    }

    public boolean removeCell(@Nullable BaseCell r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        boolean r11 = this.mCells.remove(r10);
        if (r11 == false) goto L8;
        r10.onRemoved();
    L8:
        notifyDataChange();
        return r11;
    }

    public boolean removeCellSilently(@Nullable BaseCell r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        boolean r11 = this.mCells.remove(r10);
        if (r11 == false) goto L8;
        r10.onRemoved();
    L8:
        return r11;
    }

    public boolean requirePlaceholderCell() {
        if (this.mPlaceholderRequired == true) goto L5;
    L15:
        return false;
    L5:
        if (this.mPlaceholderCell == null) goto L15;
        if (TextUtils.isEmpty(this.load) == true) goto L15;
        if (this.mCells.size() != 0) goto L11;
        return true;
    L11:
        if (this.mCells.size() != 1) goto L15;
        if (this.mCells.contains(this.mPlaceholderCell) == false) goto L15;
        return true;
    }

    public void restoreAspectRatio() {
        if (this.style != null) goto L5;
        return;
    L5:
        if (Float.isNaN(this.mTmpAspectRatio) == true) goto L9;
        Style r10 = this.style;
        r10.aspectRatio = this.mTmpAspectRatio;
        return;
    }

    public void setCells(@Nullable List<BaseCell> r10) {
        BaseCell r11 = this.mPlaceholderCell;
        if (r11 == null) goto L5;
        this.mCells.remove(r11);
    L5:
        this.oldMap.clear();
        this.pendingDeleteMap.clear();
        Iterator<BaseCell> r12 = this.mCells.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        BaseCell r13 = r12.next();
        this.oldMap.put(System.identityHashCode(r13), r13);
        goto L7
    L9:
        this.mCells.clear();
        if (r10 == null) goto L15;
        Iterator<BaseCell> r14 = r10.iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        addCellInternal(r14.next(), true);
    L15:
        adjustPendingCells(true);
        this.newMap.clear();
        Iterator<BaseCell> r15 = this.mCells.iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        BaseCell r16 = r15.next();
        this.newMap.put(System.identityHashCode(r16), r16);
        goto L17
    L19:
        int r17 = this.oldMap.size();
        int r18 = 0;
        int r19 = 0;
    L20:
        if (r19 >= r17) goto L25;
        int r20 = this.oldMap.keyAt(r19);
        if (this.newMap.get(r20) == null) goto L24;
        this.newMap.remove(r20);
        this.pendingDeleteMap.put(r20, true);
    L24:
        r19 = r19 + 1;
        goto L20
    L25:
        int r21 = this.pendingDeleteMap.size();
    L26:
        if (r18 >= r21) goto L28;
        this.oldMap.remove(this.pendingDeleteMap.keyAt(r18));
        r18 = r18 + 1;
        goto L26
    L28:
        diffCells(this.newMap, this.oldMap);
        this.newMap.clear();
        this.oldMap.clear();
        this.pendingDeleteMap.clear();
        if (requirePlaceholderCell() == false) goto L39;
        this.mCells.add(this.mPlaceholderCell);
        return;
    }

    public void setParams(@Nullable Map<String, Object> r10) {
        this.mParams = r10;
    }

    public void showPlaceholderView(boolean r10) {
        this.mPlaceholderRequired = r10;
        if (r10 == true) goto L5;
        restoreAspectRatio();
    L7:
        if (this.mCells.contains(this.mPlaceholderCell) == true) goto L12;
        if (requirePlaceholderCell() == false) goto L17;
        this.mCells.add(this.mPlaceholderCell);
        notifyDataChange();
        return;
    L17:
        return;
    L12:
        if (requirePlaceholderCell() == false) goto L14;
        return;
    L14:
        if (this.mCells.remove(this.mPlaceholderCell) == false) goto L20;
        notifyDataChange();
        return;
    L20:
        return;
    L5:
        storeAspectRatio();
        goto L7
    }

    public void storeAspectRatio() {
        Style r10 = this.style;
        if (r10 != null) goto L5;
        return;
    L5:
        if (Float.isNaN(r10.aspectRatio) == true) goto L9;
        Style r11 = this.style;
        this.mTmpAspectRatio = r11.aspectRatio;
        r11.aspectRatio = Float.NaN;
        return;
    }
}
