package androidx.paging;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
class ContiguousPagedList<K, V> extends PagedList<V> implements PagedStorage.Callback {
    private static final int DONE_FETCHING = 2;
    private static final int FETCHING = 1;
    static final int LAST_LOAD_UNSPECIFIED = -1;
    private static final int READY_TO_FETCH = 0;
    int mAppendItemsRequested;
    int mAppendWorkerState;
    final ContiguousDataSource<K, V> mDataSource;
    int mPrependItemsRequested;
    int mPrependWorkerState;
    PageResult.Receiver<V> mReceiver;
    boolean mReplacePagesWithNulls;
    final boolean mShouldTrim;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchState {
    }

    public static int getAppendItemsRequested(int r100, int r101, int r102) {
        return ((r101 + r100) + 1) - r102;
    }

    public static int getPrependItemsRequested(int r100, int r101, int r102) {
        return r100 - (r101 - r102);
    }

    @Override // androidx.paging.PagedList
    public boolean isContiguous() {
        return true;
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onEmptyAppend() {
        this.mAppendWorkerState = 2;
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onEmptyPrepend() {
        this.mPrependWorkerState = 2;
    }

    private void scheduleAppend() {
        if (this.mAppendWorkerState == 0) goto L5;
        return;
    L5:
        this.mAppendWorkerState = 1;
        final int r100 = ((this.mStorage.getLeadingNullCount() + this.mStorage.getStorageCount()) - 1) + this.mStorage.getPositionOffset();
        final Object r101 = this.mStorage.getLastLoadedItem();
        this.mBackgroundThreadExecutor.execute(new AnonymousClass3(this, r100, r101));
    }

    private void schedulePrepend() {
        if (this.mPrependWorkerState == 0) goto L5;
        return;
    L5:
        this.mPrependWorkerState = 1;
        final int r100 = this.mStorage.getLeadingNullCount() + this.mStorage.getPositionOffset();
        final Object r101 = this.mStorage.getFirstLoadedItem();
        this.mBackgroundThreadExecutor.execute(new AnonymousClass2(this, r100, r101));
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
    @Override // androidx.paging.PagedList
    public Object getLastKey() {
        return this.mDataSource.getKey(this.mLastLoad, this.mLastItem);
    }

    @Override // androidx.paging.PagedList
    public DataSource<?, V> getDataSource() {
        return this.mDataSource;
    }

    @Override // androidx.paging.PagedList
    public void loadAroundInternal(int r100) {
        int r101 = getPrependItemsRequested(this.mConfig.prefetchDistance, r100, this.mStorage.getLeadingNullCount());
        int r102 = getAppendItemsRequested(this.mConfig.prefetchDistance, r100, this.mStorage.getLeadingNullCount() + this.mStorage.getStorageCount());
        int r103 = Math.max(r101, this.mPrependItemsRequested);
        this.mPrependItemsRequested = r103;
        if (r103 <= 0) goto L5;
        schedulePrepend();
    L5:
        int r104 = Math.max(r102, this.mAppendItemsRequested);
        this.mAppendItemsRequested = r104;
        if (r104 <= 0) goto L9;
        scheduleAppend();
        return;
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onInitialized(int r100) {
        boolean r101 = false;
        notifyInserted(0, r100);
        if (this.mStorage.getLeadingNullCount() <= 0) goto L5;
    L6:
        r101 = true;
    L7:
        this.mReplacePagesWithNulls = r101;
        return;
    L5:
        if (this.mStorage.getTrailingNullCount() <= 0) goto L7;
        goto L6
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagePlaceholderInserted(int r100) {
        throw new IllegalStateException("Tiled callback on ContiguousPagedList");
    }

    @Override // androidx.paging.PagedList
    public void dispatchUpdatesSinceSnapshot(PagedList<V> r100, PagedList.Callback r101) {
        PagedStorage<V> r102 = r100.mStorage;
        int r103 = this.mStorage.getNumberAppended() - r102.getNumberAppended();
        int r104 = this.mStorage.getNumberPrepended() - r102.getNumberPrepended();
        int r105 = r102.getTrailingNullCount();
        int r106 = r102.getLeadingNullCount();
        if (r102.isEmpty() == true) goto L26;
        if (r103 < 0) goto L26;
        if (r104 < 0) goto L26;
        if (this.mStorage.getTrailingNullCount() != Math.max(r105 - r103, 0)) goto L26;
        if (this.mStorage.getLeadingNullCount() != Math.max(r106 - r104, 0)) goto L26;
        if (this.mStorage.getStorageCount() != ((r102.getStorageCount() + r103) + r104)) goto L26;
        if (r103 == 0) goto L18;
        int r107 = Math.min(r105, r103);
        int r108 = r103 - r107;
        int r109 = r102.getLeadingNullCount() + r102.getStorageCount();
        if (r107 == 0) goto L16;
        r101.onChanged(r109, r107);
    L16:
        if (r108 == 0) goto L18;
        r101.onInserted(r109 + r107, r108);
    L18:
        if (r104 == 0) goto L27;
        int r110 = Math.min(r106, r104);
        int r111 = r104 - r110;
        if (r110 == 0) goto L22;
        r101.onChanged(r106, r110);
    L22:
        if (r111 == 0) goto L28;
        r101.onInserted(0, r111);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPageInserted(int r100, int r101) {
        throw new IllegalStateException("Tiled callback on ContiguousPagedList");
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagesRemoved(int r100, int r101) {
        notifyRemoved(r100, r101);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagesSwappedToPlaceholder(int r100, int r101) {
        notifyChanged(r100, r101);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPageAppended(int r100, int r101, int r102) {
        int r103 = (this.mAppendItemsRequested - r101) - r102;
        this.mAppendItemsRequested = r103;
        this.mAppendWorkerState = 0;
        if (r103 <= 0) goto L5;
        scheduleAppend();
    L5:
        notifyChanged(r100, r101);
        notifyInserted(r100 + r101, r102);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagePrepended(int r100, int r101, int r102) {
        int r103 = (this.mPrependItemsRequested - r101) - r102;
        this.mPrependItemsRequested = r103;
        this.mPrependWorkerState = 0;
        if (r103 <= 0) goto L5;
        schedulePrepend();
    L5:
        notifyChanged(r100, r101);
        notifyInserted(0, r102);
        offsetAccessIndices(r102);
    }

    public ContiguousPagedList(ContiguousDataSource<K, V> r100, Executor r101, Executor r110, PagedList.BoundaryCallback<V> r111, PagedList.Config r112, K r113, int r114) {
        super(new PagedStorage(), r101, r110, r111, r112);
        boolean r102 = false;
        this.mPrependWorkerState = 0;
        this.mAppendWorkerState = 0;
        this.mPrependItemsRequested = 0;
        this.mAppendItemsRequested = 0;
        this.mReplacePagesWithNulls = false;
        this.mReceiver = new AnonymousClass1(this);
        this.mDataSource = r100;
        this.mLastLoad = r114;
        if (r100.isInvalid() == false) goto L5;
        detach();
    L7:
        if (r100.supportsPageDropping() == true) goto L9;
    L11:
        this.mShouldTrim = r102;
        return;
    L9:
        if (this.mConfig.maxSize == Integer.MAX_VALUE) goto L11;
        r102 = true;
        goto L11
    L5:
        PagedList.Config r115 = this.mConfig;
        r100.dispatchLoadInitial(r113, r115.initialLoadSizeHint, r115.pageSize, r115.enablePlaceholders, this.mMainThreadExecutor, this.mReceiver);
        goto L7
    }
}
