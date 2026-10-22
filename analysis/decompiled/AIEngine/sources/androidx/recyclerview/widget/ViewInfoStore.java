package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import l5.a;
import p.e;
import p.f;
import p.o;
import u0.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class ViewInfoStore {
    private static final boolean DEBUG = false;
    final o<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap = new o<>();
    final e<RecyclerView.ViewHolder> mOldChangedHolders = new e<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class InfoRecord {
        static final int FLAG_APPEAR = 2;
        static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
        static final int FLAG_APPEAR_PRE_AND_POST = 14;
        static final int FLAG_DISAPPEARED = 1;
        static final int FLAG_POST = 8;
        static final int FLAG_PRE = 4;
        static final int FLAG_PRE_AND_POST = 12;
        static c<InfoRecord> sPool = new a(20);
        int flags;
        RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
        RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        private InfoRecord() {
        }

        public static void drainCache() {
            while (sPool.acquire() != null) {
            }
        }

        public static InfoRecord obtain() {
            InfoRecord infoRecordAcquire = sPool.acquire();
            return infoRecordAcquire == null ? new InfoRecord() : infoRecordAcquire;
        }

        public static void recycle(InfoRecord infoRecord) {
            infoRecord.flags = 0;
            infoRecord.preInfo = null;
            infoRecord.postInfo = null;
            sPool.release(infoRecord);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processDisappeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processPersistent(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void unused(RecyclerView.ViewHolder viewHolder);
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder viewHolder, int i10) {
        InfoRecord infoRecordJ;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int iE = this.mLayoutHolderMap.e(viewHolder);
        if (iE >= 0 && (infoRecordJ = this.mLayoutHolderMap.j(iE)) != null) {
            int i11 = infoRecordJ.flags;
            if ((i11 & i10) != 0) {
                int i12 = (~i10) & i11;
                infoRecordJ.flags = i12;
                if (i10 == 4) {
                    itemHolderInfo = infoRecordJ.preInfo;
                } else {
                    if (i10 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    itemHolderInfo = infoRecordJ.postInfo;
                }
                if ((i12 & 12) == 0) {
                    this.mLayoutHolderMap.h(iE);
                    InfoRecord.recycle(infoRecordJ);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    public void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecordObtain);
        }
        infoRecordObtain.flags |= 2;
        infoRecordObtain.preInfo = itemHolderInfo;
    }

    public void addToDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecordObtain);
        }
        infoRecordObtain.flags |= 1;
    }

    public void addToOldChangeHolders(long j10, RecyclerView.ViewHolder viewHolder) {
        this.mOldChangedHolders.f(j10, viewHolder);
    }

    public void addToPostLayout(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecordObtain);
        }
        infoRecordObtain.postInfo = itemHolderInfo;
        infoRecordObtain.flags |= 8;
    }

    public void addToPreLayout(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecordObtain);
        }
        infoRecordObtain.preInfo = itemHolderInfo;
        infoRecordObtain.flags |= 4;
    }

    public void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.b();
    }

    public RecyclerView.ViewHolder getFromOldChangeHolders(long j10) {
        return this.mOldChangedHolders.d(j10);
    }

    public boolean isDisappearing(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        return (infoRecord == null || (infoRecord.flags & 1) == 0) ? false : true;
    }

    public boolean isInPreLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        return (infoRecord == null || (infoRecord.flags & 4) == 0) ? false : true;
    }

    public void onDetach() {
        InfoRecord.drainCache();
    }

    public void onViewDetached(RecyclerView.ViewHolder viewHolder) {
        removeFromDisappearedInLayout(viewHolder);
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder viewHolder) {
        return popFromLayoutStep(viewHolder, 8);
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder viewHolder) {
        return popFromLayoutStep(viewHolder, 4);
    }

    public void process(ProcessCallback processCallback) {
        for (int i10 = this.mLayoutHolderMap.f11385c - 1; i10 >= 0; i10--) {
            RecyclerView.ViewHolder viewHolderG = this.mLayoutHolderMap.g(i10);
            InfoRecord infoRecordH = this.mLayoutHolderMap.h(i10);
            int i11 = infoRecordH.flags;
            if ((i11 & 3) == 3) {
                processCallback.unused(viewHolderG);
            } else if ((i11 & 1) != 0) {
                RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = infoRecordH.preInfo;
                if (itemHolderInfo == null) {
                    processCallback.unused(viewHolderG);
                } else {
                    processCallback.processDisappeared(viewHolderG, itemHolderInfo, infoRecordH.postInfo);
                }
            } else if ((i11 & 14) == 14) {
                processCallback.processAppeared(viewHolderG, infoRecordH.preInfo, infoRecordH.postInfo);
            } else if ((i11 & 12) == 12) {
                processCallback.processPersistent(viewHolderG, infoRecordH.preInfo, infoRecordH.postInfo);
            } else if ((i11 & 4) != 0) {
                processCallback.processDisappeared(viewHolderG, infoRecordH.preInfo, null);
            } else if ((i11 & 8) != 0) {
                processCallback.processAppeared(viewHolderG, infoRecordH.preInfo, infoRecordH.postInfo);
            }
            InfoRecord.recycle(infoRecordH);
        }
    }

    public void removeFromDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.flags &= -2;
    }

    public void removeViewHolder(RecyclerView.ViewHolder viewHolder) {
        int iG = this.mOldChangedHolders.g() - 1;
        while (true) {
            if (iG < 0) {
                break;
            }
            if (viewHolder == this.mOldChangedHolders.h(iG)) {
                e<RecyclerView.ViewHolder> eVar = this.mOldChangedHolders;
                Object[] objArr = eVar.f11362c;
                Object obj = objArr[iG];
                Object obj2 = f.f11364a;
                if (obj != obj2) {
                    objArr[iG] = obj2;
                    eVar.f11360a = true;
                }
            } else {
                iG--;
            }
        }
        InfoRecord infoRecordRemove = this.mLayoutHolderMap.remove(viewHolder);
        if (infoRecordRemove != null) {
            InfoRecord.recycle(infoRecordRemove);
        }
    }
}
