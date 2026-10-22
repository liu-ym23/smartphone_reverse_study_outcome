package com.tmall.wireless.tangram;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.extend.InnerRecycledViewPool;
import com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.DataParser;
import com.tmall.wireless.tangram.dataparser.IAdapterBuilder;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.support.TimerSupport;
import com.tmall.wireless.tangram.util.Preconditions;
import com.tmall.wireless.tangram.util.Predicate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class BaseTangramEngine<T, C, L> implements ServiceManager {
    private final IAdapterBuilder<C, ?> mAdapterBuilder;
    private RecyclerView mContentView;

    @NonNull
    private final Context mContext;
    private final DataParser<T, C, L> mDataParser;
    protected GroupBasicAdapter<C, ?> mGroupBasicAdapter;
    private final VirtualLayoutManager mLayoutManager;
    private Map<Class<?>, Object> mServices;

    public BaseTangramEngine(@NonNull Context r10, @NonNull DataParser<T, C, L> r11, @NonNull IAdapterBuilder<C, ?> r12) {
        this.mServices = new ArrayMap();
        if (r10 == null) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "context is null");
        this.mContext = r10;
        VirtualLayoutManager r14 = new VirtualLayoutManager(r10);
        this.mLayoutManager = r14;
        r14.setLayoutViewFactory(new AnonymousClass1(this));
        this.mDataParser = (DataParser) Preconditions.checkNotNull(r11, "dataParser in constructor should not be null");
        this.mAdapterBuilder = (IAdapterBuilder) Preconditions.checkNotNull(r12, "adapterBuilder in constructor should not be null");
        return;
    L5:
        r13 = false;
        goto L6
    }

    public void appendData(@Nullable T r10) {
        if (this.mGroupBasicAdapter == null) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkState(r11, "Must call bindView() first");
        appendData(this.mDataParser.parseGroup(r10, this));
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void bindView(@NonNull RecyclerView r10) {
        if (r10 == null) goto L4;
        boolean r11 = true;
    L5:
        Preconditions.checkArgument(r11, "view must not be null");
        RecyclerView r12 = this.mContentView;
        if (r12 == null) goto L8;
        r12.setAdapter(null);
        this.mContentView.setLayoutManager(null);
    L8:
        this.mContentView = r10;
        r10.setLayoutManager(this.mLayoutManager);
        if (this.mGroupBasicAdapter != null) goto L12;
        this.mGroupBasicAdapter = this.mAdapterBuilder.newAdapter(this.mContext, this.mLayoutManager, this);
    L12:
        if (this.mContentView.getRecycledViewPool() == null) goto L14;
        RecyclerView r13 = this.mContentView;
        r13.setRecycledViewPool(new InnerRecycledViewPool(r13.getRecycledViewPool()));
    L14:
        register(GroupBasicAdapter.class, this.mGroupBasicAdapter);
        register(RecyclerView.RecycledViewPool.class, this.mContentView.getRecycledViewPool());
        this.mContentView.setAdapter(this.mGroupBasicAdapter);
        return;
    L4:
        r11 = false;
        goto L5
    }

    public void destroy() {
        if (this.mContentView == null) goto L8;
        GroupBasicAdapter<C, ?> r10 = this.mGroupBasicAdapter;
        if (r10 == null) goto L7;
        r10.destroy();
    L7:
        this.mContentView.setAdapter(null);
        this.mContentView = null;
    L8:
        TimerSupport r11 = (TimerSupport) getService(TimerSupport.class);
        if (r11 == null) goto L11;
        r11.clear();
    L11:
        BusSupport r12 = (BusSupport) getService(BusSupport.class);
        if (r12 == null) goto L15;
        r12.shutdown();
        return;
    }

    @NonNull
    public <C> List<C> findGroups(Predicate<C> r10) {
        if (this.mGroupBasicAdapter == null) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkState(r11, "Must call bindView() first");
        List<C> r12 = this.mGroupBasicAdapter.getGroups();
        if (r10 != null) goto L9;
        return r12;
    L9:
        LinkedList r13 = new LinkedList();
        Iterator<C> r14 = r12.iterator();
    L11:
        if (r14.hasNext() == false) goto L15;
        C r15 = r14.next();
        if (r10.isMatch(r15) == false) goto L11;
        r13.add(r15);
        goto L11
    L15:
        return r13;
    L5:
        r11 = false;
        goto L6
    }

    public RecyclerView getContentView() {
        if (this.mContentView != null) goto L10;
        bindView(new RecyclerView(this.mContext));
        if (this.mContentView == null) goto L7;
        boolean r10 = true;
    L8:
        Preconditions.checkState(r10, "mContentView is still null after call bindView()");
        goto L10
    L7:
        r10 = false;
    L10:
        return this.mContentView;
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    public GroupBasicAdapter<C, ?> getGroupBasicAdapter() {
        return this.mGroupBasicAdapter;
    }

    public VirtualLayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    @Override // com.tmall.wireless.tangram.core.service.ServiceManager
    public <S> S getService(@NonNull Class<S> r10) {
        Object r11 = this.mServices.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r10.cast(r11);
    }

    public void insertData(int r10, @Nullable T r11) {
        if (this.mGroupBasicAdapter == null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "Must call bindView() first");
        insertData(r10, this.mDataParser.parseGroup(r11, this));
        return;
    L5:
        r12 = false;
        goto L6
    }

    public boolean isFullScreen() {
        this.mLayoutManager.findLastVisibleItemPosition();
        return false;
    }

    public List<L> parseComponent(@Nullable T r10) {
        return this.mDataParser.parseComponent(r10, this);
    }

    public List<C> parseData(@Nullable T r10) {
        return this.mDataParser.parseGroup(r10, this);
    }

    @Override // com.tmall.wireless.tangram.core.service.ServiceManager
    public <S> void register(@NonNull Class<S> r10, @NonNull S r11) {
        if (r10 == null) goto L4;
        boolean r12 = true;
    L5:
        Preconditions.checkArgument(r12, "type is null");
        this.mServices.put(r10, r10.cast(r11));
        return;
    L4:
        r12 = false;
        goto L5
    }

    public void replaceData(int r10, @Nullable T r11) {
        if (this.mGroupBasicAdapter == null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "Must call bindView() first");
        replaceData(r10, this.mDataParser.parseGroup(r11, this));
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void setData(@Nullable T r10) {
        if (this.mGroupBasicAdapter == null) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkState(r11, "Must call bindView() first");
        setData(this.mDataParser.parseGroup(r10, this));
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void unbindView() {
        RecyclerView r10 = this.mContentView;
        if (r10 == null) goto L6;
        r10.setAdapter(null);
        this.mContentView.setLayoutManager(null);
        this.mContentView = null;
        return;
    }

    public void appendData(@Nullable List<C> r10) {
        if (this.mGroupBasicAdapter == null) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkState(r11, "Must call bindView() first");
        this.mGroupBasicAdapter.appendGroup(r10);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void insertData(int r10, @Nullable List<C> r11) {
        if (this.mGroupBasicAdapter == null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "Must call bindView() first");
        this.mGroupBasicAdapter.insertGroup(r10, r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void replaceData(int r10, @Nullable List<C> r11) {
        if (this.mGroupBasicAdapter == null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "Must call bindView() first");
        this.mGroupBasicAdapter.replaceGroup(r10, r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void setData(@Nullable List<C> r10) {
        if (this.mGroupBasicAdapter == null) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkState(r11, "Must call bindView() first");
        MVHelper r12 = (MVHelper) this.mServices.get(MVHelper.class);
        if (r12 == null) goto L9;
        r12.reset();
    L9:
        this.mGroupBasicAdapter.setData(r10);
        return;
    L5:
        r11 = false;
        goto L6
    }
}
