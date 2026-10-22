package com.bytedanceos.common.networkv2.data;

import com.bytedanceos.common.toolbox.i;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PagedListDataModel<T> {
    public static final String TAG = "PagedListDataModel";
    private boolean mIsFirst;
    protected ListPageInfo<T> mListPageInfo;
    private PagedListDataHandler mPagedListDataHandler;

    public interface PagedListDataHandler {
        void onPageDataLoaded(ListPageInfo<?> r10, int r11);
    }

    public PagedListDataModel() {
        this.mIsFirst = false;
    }

    private void checkPageInfo() {
        if (this.mListPageInfo == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(" mListPageInfo has not been initialized.");
    }

    private boolean doQueryDataInner() {
        if (this.mListPageInfo.tryEnterLock() == true) goto L6;
        return false;
    L6:
        doQueryData();
        return true;
    }

    public void destroy() {
        ListPageInfo<T> r10 = this.mListPageInfo;
        if (r10 == null) goto L6;
        r10.destroy();
        return;
    }

    public abstract void doQueryData();

    public ListPageInfo<T> getListPageInfo() {
        return this.mListPageInfo;
    }

    public boolean isFirstRequest() {
        return this.mIsFirst;
    }

    public void queryFirstPage(boolean r10) {
        this.mIsFirst = r10;
        checkPageInfo();
        this.mListPageInfo.goToHead();
        if (this.mListPageInfo.prepareForNextPage() == false) goto L6;
        doQueryDataInner();
        return;
    }

    public void queryNextPage() {
        this.mIsFirst = false;
        checkPageInfo();
        if (this.mListPageInfo.prepareForNextPage() == true) goto L5;
        i.b(TAG, "query next page not start");
        return;
    L5:
        if (doQueryDataInner() == true) goto L11;
        this.mListPageInfo.rollbackOnFail();
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
    public void sendPageData(int r10) {
        PagedListDataHandler r11 = this.mPagedListDataHandler;
        if (r11 == null) goto L6;
        r11.onPageDataLoaded(this.mListPageInfo, r10);
        return;
    }

    public void setPageListDataHandler(PagedListDataHandler r10) {
        this.mPagedListDataHandler = r10;
    }

    public void setRequestFail() {
        this.mListPageInfo.rollbackOnFail();
        this.mListPageInfo.releaseLock();
    }

    public void setRequestResult(List<T> r10, int r11) {
        this.mListPageInfo.updateListInfo(r10, r11);
    }

    public void setRequestResult(List<T> r10, boolean r11) {
        this.mListPageInfo.updateListInfo(r10, r11);
    }

    public void queryFirstPage() {
        queryFirstPage(true);
    }
}
