package com.tmall.wireless.tangram;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.Range;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.view.RecyclerviewCompat;
import com.tmall.wireless.tangram.dataparser.DataParser;
import com.tmall.wireless.tangram.dataparser.IAdapterBuilder;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.expression.ITangramExprParser;
import com.tmall.wireless.tangram.expression.TangramExpr;
import com.tmall.wireless.tangram.expression.TangramExprSupport;
import com.tmall.wireless.tangram.ext.PullFromEndListener;
import com.tmall.wireless.tangram.ext.SwipeItemTouchListener;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.support.ExposureSupport;
import com.tmall.wireless.tangram.support.SimpleClickSupport;
import com.tmall.wireless.tangram.support.async.CardLoadSupport;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public class TangramEngine extends BaseTangramEngine<JSONArray, Card, BaseCell> implements Engine, ITangramExprParser {
    private static final int NO_SWIPE = -1;
    private boolean mEnableAutoLoadMore;
    private boolean mEnableLoadFirstPageCard;
    private int mPreLoadNumber;
    private int mSwipeCardActionEdge;
    private SwipeItemTouchListener mSwipeItemTouchListener;
    private TangramExprSupport mTangramExprSupport;
    private Runnable updateRunnable;

    public TangramEngine(@NonNull Context r10, @NonNull DataParser<JSONArray, Card, BaseCell> r11, @NonNull IAdapterBuilder<Card, ?> r12) {
        super(r10, r11, r12);
        this.mPreLoadNumber = 5;
        this.mEnableAutoLoadMore = true;
        this.mEnableLoadFirstPageCard = true;
        this.mSwipeItemTouchListener = null;
        this.mSwipeCardActionEdge = -1;
        register(DataParser.class, r11);
        TangramExprSupport r13 = new TangramExprSupport();
        this.mTangramExprSupport = r13;
        r13.registerExprParser(TangramExprSupport.TANGRAM, this);
        register(TangramExprSupport.class, this.mTangramExprSupport);
    }

    public void addCardLoadSupport(@NonNull CardLoadSupport r10) {
        register(CardLoadSupport.class, r10);
    }

    public void addExposureSupport(@NonNull ExposureSupport r10) {
        register(ExposureSupport.class, r10);
    }

    public void addSimpleClickSupport(@NonNull SimpleClickSupport r10) {
        register(SimpleClickSupport.class, r10);
    }

    @Override // com.tmall.wireless.tangram.BaseTangramEngine
    public void bindView(@NonNull RecyclerView r10) {
        super.bindView(r10);
        SwipeItemTouchListener r11 = new SwipeItemTouchListener(r10.getContext(), this.mGroupBasicAdapter, getContentView());
        this.mSwipeItemTouchListener = r11;
        int r12 = this.mSwipeCardActionEdge;
        if (r12 == (-1)) goto L5;
        r11.setActionEdge(r12);
    L5:
        r10.addOnItemTouchListener(this.mSwipeItemTouchListener);
    }

    @Override // com.tmall.wireless.tangram.BaseTangramEngine
    public void destroy() {
        RecyclerView r10 = getContentView();
        if (r10 == null) goto L5;
        r10.removeCallbacks(this.updateRunnable);
    L5:
        super.destroy();
    }

    public void enableAutoLoadMore(boolean r10) {
        this.mEnableAutoLoadMore = r10;
    }

    public Card findCardById(String r10) {
        MVHelper r11 = (MVHelper) getService(MVHelper.class);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.resolver().findCardById(r10);
    }

    @Override // com.tmall.wireless.tangram.expression.ITangramExprParser
    public Object getValueBy(TangramExpr r10) {
        if (r10.hasNextFragment() == false) goto L13;
        String r11 = r10.nextFragment();
        List<Card> r12 = getGroupBasicAdapter().getGroups();
        int r13 = r12.size();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L19;
        Card r15 = r12.get(r14);
        String r16 = r15.f18212id;
        if (r16 == null) goto L12;
        if (r16.equals(r11) == false) goto L12;
        return r15.getValueBy(r10);
    L12:
        r14 = r14 + 1;
        goto L5
    L19:
        return null;
    L13:
        return null;
    }

    public void loadFirstPageCard() {
        if (this.mEnableLoadFirstPageCard == true) goto L5;
        return;
    L5:
        CardLoadSupport r10 = (CardLoadSupport) getService(CardLoadSupport.class);
        if (r10 != null) goto L8;
        return;
    L8:
        List r11 = this.mGroupBasicAdapter.getGroups();
        int r12 = 0;
        boolean r13 = false;
    L10:
        if (r12 >= Math.min(this.mPreLoadNumber, r11.size())) goto L22;
        Card r14 = (Card) r11.get(r12);
        if (TextUtils.isEmpty(r14.load) == true) goto L21;
        if (r14.loaded == true) goto L21;
        if (r14.loadMore == false) goto L19;
        if (r13 == true) goto L19;
        r10.loadMore(r14);
        r13 = true;
    L20:
        r14.loaded = true;
    L19:
        r10.doLoad(r14);
    L21:
        r12 = r12 + 1;
        goto L10
    }

    public void loadMoreCard() {
        CardLoadSupport r10 = (CardLoadSupport) getService(CardLoadSupport.class);
        if (r10 != null) goto L5;
        return;
    L5:
        List<Card> r11 = findGroups(new AnonymousClass1(this));
        if (r11.size() == 0) goto L9;
        r10.loadMore(r11.get(r11.size() - 1));
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onScrolled() {
        int r10 = getLayoutManager().findLastVisibleItemPosition();
        int r11 = getLayoutManager().findFirstVisibleItemPosition();
        int r12 = -1;
        int r13 = r10;
        int r14 = -1;
    L3:
        if (r13 < r11) goto L8;
        r14 = this.mGroupBasicAdapter.findCardIdxFor(r13);
        if (r14 >= 0) goto L9;
        r13 = r13 - 1;
    L9:
        int r15 = -1;
    L10:
        if (r12 > r10) goto L15;
        r15 = this.mGroupBasicAdapter.findCardIdxFor(r12);
        if (r15 >= 0) goto L15;
        r12 = r12 + 1;
    L15:
        if (r14 < 0) goto L62;
        if (r15 < 0) goto L65;
        CardLoadSupport r16 = (CardLoadSupport) getService(CardLoadSupport.class);
        if (r16 != null) goto L21;
        return;
    L21:
        List r17 = this.mGroupBasicAdapter.getGroups();
        Card r18 = (Card) r17.get(r14);
        Pair r19 = this.mGroupBasicAdapter.getCardRange(r14);
        if (r19 != null) goto L24;
    L33:
        boolean r20 = false;
    L35:
        if (r15 >= Math.min(this.mPreLoadNumber + r14, r17.size())) goto L48;
        Card r21 = (Card) r17.get(r15);
        if (TextUtils.isEmpty(r21.load) == true) goto L46;
        if (r21.loaded == true) goto L46;
        if (r21.loadMore == false) goto L44;
        if (r20 == true) goto L44;
        r16.loadMore(r21);
        r20 = true;
    L45:
        r21.loaded = true;
    L44:
        r16.doLoad(r21);
    L46:
        r15 = r15 + 1;
        goto L35
    L48:
        if (this.mEnableAutoLoadMore == true) goto L50;
        return;
    L50:
        if ((this.mGroupBasicAdapter.getItemCount() - r13) >= this.mPreLoadNumber) goto L64;
        loadMoreCard();
        return;
    L64:
        return;
    L24:
        if (r13 < (((Integer) ((Range) r19.first).getUpper()).intValue() - this.mPreLoadNumber)) goto L33;
        if (TextUtils.isEmpty(r18.load) == true) goto L33;
        if (r18.loaded == false) goto L33;
        if (r18.loadMore == false) goto L61;
        r16.loadMore(r18);
        return;
    L61:
        return;
    L65:
        return;
    L62:
        return;
    L8:
        r13 = r10;
        goto L9
    }

    @Override // com.tmall.wireless.tangram.Engine
    public void refresh(final boolean r10) {
        final RecyclerviewCompat r11 = (RecyclerviewCompat) getContentView();
        if (r11 != null) goto L5;
        return;
    L5:
        r11.getScrollState();
        Runnable r12 = new AnonymousClass2(this, r11, r10);
        this.updateRunnable = r12;
        r11.post(r12);
    }

    @Override // com.tmall.wireless.tangram.Engine
    public void replaceCard(Card r10, Card r11) {
        int r12 = this.mGroupBasicAdapter.getGroups().indexOf(r10);
        if (r12 < 0) goto L6;
        replaceData(r12, Collections.singletonList(r11));
        return;
    }

    @Override // com.tmall.wireless.tangram.Engine
    public void replaceCells(Card r10, List<BaseCell> r11) {
        if (r10 == null) goto L6;
        if (r11 == null) goto L7;
        r10.setCells(r11);
        r10.notifyDataChange();
        return;
    L7:
        return;
    }

    @Override // com.tmall.wireless.tangram.Engine
    public void scrollToPosition(Card r10) {
        List<BaseCell> r11 = r10.getCells();
        if (r11.size() <= 0) goto L8;
        BaseCell r12 = r11.get(0);
        int r13 = this.mGroupBasicAdapter.getComponents().indexOf(r12);
        if (r13 <= 0) goto L9;
        getContentView().scrollToPosition(r13);
        return;
    L9:
        return;
    }

    @Override // com.tmall.wireless.tangram.BaseTangramEngine
    public /* bridge */ /* synthetic */ void setData(@Nullable JSONArray r10) {
        setData2(r10);
    }

    public void setEnableLoadFirstPageCard(boolean r10) {
        this.mEnableLoadFirstPageCard = r10;
    }

    public void setNoScrolling(boolean r10) {
        getLayoutManager().setNoScrolling(r10);
    }

    public void setPreLoadNumber(int r10) {
        if (r10 < 0) goto L4;
        this.mPreLoadNumber = r10;
        return;
    L4:
        this.mPreLoadNumber = 0;
    }

    public void setPullFromEndListener(PullFromEndListener r10) {
        SwipeItemTouchListener r11 = this.mSwipeItemTouchListener;
        if (r11 == null) goto L6;
        r11.setPullFromEndListener(r10);
        return;
    }

    public void setSwipeCardActionEdge(int r10) {
        if (r10 == (-1)) goto L5;
        this.mSwipeCardActionEdge = r10;
        if (this.mSwipeItemTouchListener == null) goto L13;
        getContentView().removeOnItemTouchListener(this.mSwipeItemTouchListener);
        this.mSwipeItemTouchListener.setActionEdge(r10);
        getContentView().addOnItemTouchListener(this.mSwipeItemTouchListener);
        return;
    L13:
        return;
    L5:
        if (this.mSwipeItemTouchListener == null) goto L11;
        getContentView().removeOnItemTouchListener(this.mSwipeItemTouchListener);
        return;
    }

    @Override // com.tmall.wireless.tangram.Engine
    public void topPosition(Card r10) {
        List<BaseCell> r11 = r10.getCells();
        if (r11.size() <= 0) goto L11;
        BaseCell r12 = r11.get(0);
        int r13 = this.mGroupBasicAdapter.getComponents().indexOf(r12);
        if (r13 <= 0) goto L12;
        VirtualLayoutManager r14 = getLayoutManager();
        View r15 = r14.findViewByPosition(r13);
        if (r15 == null) goto L9;
        int r16 = r14.getDecoratedTop(r15);
        getContentView().scrollBy(0, r16);
        return;
    L9:
        getContentView().scrollToPosition(r13);
        return;
    L12:
        return;
    }

    @Override // com.tmall.wireless.tangram.BaseTangramEngine
    public void unbindView() {
        RecyclerView r10 = getContentView();
        if (r10 == null) goto L7;
        SwipeItemTouchListener r11 = this.mSwipeItemTouchListener;
        if (r11 == null) goto L7;
        r10.removeOnItemTouchListener(r11);
        this.mSwipeItemTouchListener = null;
    L7:
        super.unbindView();
    }

    /* JADX INFO: renamed from: setData, reason: avoid collision after fix types in other method */
    public void setData2(@Nullable JSONArray r10) {
        super.setData(r10);
        loadFirstPageCard();
    }

    @Override // com.tmall.wireless.tangram.BaseTangramEngine
    public void setData(@Nullable List<Card> r10) {
        super.setData(r10);
        loadFirstPageCard();
    }

    @Override // com.tmall.wireless.tangram.Engine
    public void refresh() {
        refresh(true);
    }

    @Override // com.tmall.wireless.tangram.Engine
    public void scrollToPosition(BaseCell r10) {
        if (r10 == null) goto L7;
        int r11 = this.mGroupBasicAdapter.getComponents().indexOf(r10);
        if (r11 <= 0) goto L8;
        getContentView().scrollToPosition(r11);
        return;
    L8:
        return;
    }

    @Override // com.tmall.wireless.tangram.Engine
    public void topPosition(BaseCell r10) {
        if (r10 == null) goto L10;
        int r11 = this.mGroupBasicAdapter.getComponents().indexOf(r10);
        if (r11 <= 0) goto L11;
        VirtualLayoutManager r12 = getLayoutManager();
        View r13 = r12.findViewByPosition(r11);
        if (r13 == null) goto L8;
        int r14 = r12.getDecoratedTop(r13);
        getContentView().scrollBy(0, r14);
        return;
    L8:
        getContentView().scrollToPosition(r11);
        return;
    L11:
        return;
    }
}
