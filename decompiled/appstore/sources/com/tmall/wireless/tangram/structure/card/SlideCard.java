package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.WrapperCard;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.eventbus.Event;
import com.tmall.wireless.tangram.eventbus.EventHandlerWrapper;
import com.tmall.wireless.tangram.structure.BaseCell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public class SlideCard extends WrapperCard implements SwipeCard {
    public static final String KEY_INDEX = "index";
    public static final String KEY_PAGE_COUNT = "pageCount";
    private ArrayMap args;
    private Map<Integer, TabContentCache> mCacheMap;
    private int mIndex;
    private EventHandlerWrapper mSetMeta;
    private int mTotalPageCount;

    public static final class TabContentCache {
        public List<BaseCell> cells;
        public boolean hasMore;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f18216id;
        int index;
        public boolean loaded;
        public boolean loading;
        public int page;

        public TabContentCache(int r10, List<BaseCell> r11, BaseCell r12) {
            this.loaded = true;
            this.loading = false;
            this.index = r10;
            ArrayList r13 = new ArrayList(r11);
            this.cells = r13;
            r13.remove(r12);
        }
    }

    public SlideCard(@NonNull Card r10) {
        super(r10);
        this.args = new ArrayMap();
        this.mCacheMap = new HashMap();
        this.mSetMeta = BusSupport.wrapEventHandler("setMeta", null, this, "parseMeta");
        this.mIndex = 0;
        this.mTotalPageCount = Channel.UNLIMITED;
    }

    private void storeCache() {
        List<BaseCell> r10 = getCells();
        BaseCell r11 = getPlaceholderCell();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L9;
        TabContentCache r12 = new TabContentCache(this.mIndex, r10, r11);
        r12.f18216id = this.f18212id;
        r12.loaded = this.loaded;
        r12.loading = this.loading;
        r12.page = this.page;
        r12.hasMore = this.hasMore;
        this.mCacheMap.put(Integer.valueOf(this.mIndex), r12);
        return;
    }

    @Override // com.tmall.wireless.tangram.structure.card.SwipeCard
    public int getCurrentIndex() {
        return this.mIndex;
    }

    public TabContentCache getIndexCache(int r10) {
        return this.mCacheMap.get(Integer.valueOf(r10));
    }

    @Override // com.tmall.wireless.tangram.structure.card.SwipeCard
    public int getTotalPage() {
        return this.mTotalPageCount;
    }

    public boolean hasCacheOf(int r10) {
        TabContentCache r11 = this.mCacheMap.get(Integer.valueOf(r10));
        if (r11 == null) goto L9;
        List<BaseCell> r12 = r11.cells;
        if (r12 == null) goto L9;
        if (r12.isEmpty() == true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card, com.tmall.wireless.tangram.dataparser.concrete.ComponentLifecycle
    public void onAdded() {
        super.onAdded();
        i.a("Longer", "add slide grid card");
        ServiceManager r10 = this.serviceManager;
        if (r10 != null) goto L5;
        return;
    L5:
        BusSupport r11 = (BusSupport) r10.getService(BusSupport.class);
        if (r11 == null) goto L9;
        r11.register(this.mSetMeta);
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card, com.tmall.wireless.tangram.dataparser.concrete.ComponentLifecycle
    public void onRemoved() {
        super.onRemoved();
        i.a("Longer", "remove slide grid card");
        ServiceManager r10 = this.serviceManager;
        if (r10 == null) goto L8;
        BusSupport r11 = (BusSupport) r10.getService(BusSupport.class);
        if (r11 == null) goto L9;
        r11.unregister(this.mSetMeta);
        return;
    L9:
        return;
    }

    public void parseMeta(Event r10) {
        i.a("Longer", "current meta " + this.mIndex + " " + this.mTotalPageCount + " < " + r10.sourceId);     // Catch: Exception -> L8
        if (this.mTotalPageCount == Integer.MAX_VALUE) goto L6;
        storeCache();     // Catch: Exception -> L8
    L6:
        this.mIndex = Integer.parseInt((String) r10.args.get(KEY_INDEX));     // Catch: Exception -> L8
        this.mTotalPageCount = Integer.parseInt((String) r10.args.get(KEY_PAGE_COUNT));     // Catch: Exception -> L8
        i.a("Longer", "parse meta " + this.mIndex + " " + this.mTotalPageCount);     // Catch: Exception -> L8
        return;
    }

    @Override // com.tmall.wireless.tangram.structure.card.SwipeCard
    public void switchTo(int r10) {
        ServiceManager r11 = this.serviceManager;
        if (r11 == null) goto L8;
        BusSupport r12 = (BusSupport) r11.getService(BusSupport.class);
        if (r12 == null) goto L9;
        i.a("Longer", "switch from " + this.mIndex);
        storeCache();
        this.args.put(KEY_INDEX, String.valueOf(r10));
        i.a("Longer", "switch to " + r10);
        r12.post(BusSupport.obtainEvent("switchTo", null, this.args, null));
        this.mIndex = r10;
        return;
    L9:
        return;
    }
}
