package com.tmall.wireless.tangram.structure;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.tmall.wireless.tangram.Engine;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.ComponentLifecycle;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.expression.ITangramExprParser;
import com.tmall.wireless.tangram.expression.TangramExpr;
import com.tmall.wireless.tangram.support.SimpleClickSupport;
import com.tmall.wireless.tangram.util.IInnerImageSetter;
import com.tmall.wireless.tangram.util.ImageUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BaseCell<V extends View> extends ComponentLifecycle implements View.OnClickListener, ITangramExprParser {
    private static AtomicLong sIdGen;
    public static boolean sIsGenIds;
    private ArrayMap bizParaMap;
    public JSONObject extras;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @Nullable
    public String f18213id;
    public boolean inlineCard;
    private ArrayMap innerClickMap;
    public boolean mIsExposed;
    public ComponentLifecycle nestedParent;
    public final long objectId;
    public Card parent;

    @Nullable
    public String parentId;
    public int pos;
    public int position;

    @Nullable
    public ServiceManager serviceManager;

    @Nullable
    public Style style;
    public int type;
    public String typeKey;

    static {
        sIdGen = new AtomicLong();
        sIsGenIds = false;
    }

    public BaseCell() {
        this.position = -1;
        this.extras = new JSONObject();
        this.bizParaMap = new ArrayMap(32);
        this.innerClickMap = new ArrayMap();
        this.mIsExposed = false;
        if (sIsGenIds == false) goto L5;
        long r10 = sIdGen.getAndIncrement();
    L6:
        this.objectId = r10;
        return;
    L5:
        r10 = 0;
        goto L6
    }

    public void addBizParam(String r10, Object r11) {
        this.bizParaMap.put(r10, r11);
    }

    public void bindView(@NonNull V r10) {
    }

    public final void doLoadImageUrl(ImageView r10, String r11) {
        ServiceManager r12 = this.serviceManager;
        if (r12 != null) goto L5;
    L7:
        ImageUtils.doLoadImageUrl(r10, r11);
        return;
    L5:
        if (r12.getService(IInnerImageSetter.class) == null) goto L7;
        ((IInnerImageSetter) this.serviceManager.getService(IInnerImageSetter.class)).doLoadImageUrl(r10, r11, 0.0f, false);
    }

    public Map<String, Object> getAllBizParams() {
        return this.bizParaMap;
    }

    @Override // com.tmall.wireless.tangram.expression.ITangramExprParser
    public Object getValueBy(TangramExpr r10) {
        if (r10.hasNextFragment() == false) goto L7;
        return optParam(r10.nextFragment());
    L7:
        return this.extras;
    }

    public boolean hasParam(String r10) {
        if (this.extras.has(r10) == true) goto L12;
        Style r11 = this.style;
        if (r11 == null) goto L11;
        JSONObject r12 = r11.extras;
        if (r12 == null) goto L11;
        if (r12.has(r10) == true) goto L12;
    L11:
        return false;
    L12:
        return true;
    }

    public boolean isValid() {
        return true;
    }

    public final void notifyDataChange() {
        ServiceManager r10 = this.serviceManager;
        if ((r10 instanceof Engine) == false) goto L6;
        ((Engine) r10).refresh(false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        ServiceManager r11 = this.serviceManager;
        if (r11 == null) goto L11;
        SimpleClickSupport r12 = (SimpleClickSupport) r11.getService(SimpleClickSupport.class);
        if (r12 == null) goto L12;
        int r13 = this.pos;
        if (this.innerClickMap.containsKey(r10) == false) goto L9;
        r13 = ((Integer) this.innerClickMap.get(r10)).intValue();
    L9:
        r12.onClick(r10, this, r13);
        return;
    L12:
        return;
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

    public void parseStyle(@Nullable JSONObject r10) {
    }

    public void parseWith(JSONObject r10) {
    }

    public void postBindView(@NonNull V r10) {
    }

    public void setOnClickListener(View r10, int r11) {
        r10.setOnClickListener(this);
        this.innerClickMap.put(r10, Integer.valueOf(r11));
    }

    public void unbindView(@NonNull V r10) {
    }

    public void parseWith(@NonNull JSONObject r10, @NonNull MVHelper r11) {
    }

    public BaseCell(int r10) {
        this.position = -1;
        this.extras = new JSONObject();
        this.bizParaMap = new ArrayMap(32);
        this.innerClickMap = new ArrayMap();
        this.mIsExposed = false;
        this.type = r10;
        if (sIsGenIds == false) goto L5;
        long r11 = sIdGen.getAndIncrement();
    L6:
        this.objectId = r11;
        return;
    L5:
        r11 = 0;
        goto L6
    }
}
