package androidx.recyclerview.widget;

import D.e;
import androidx.recyclerview.widget.RecyclerView;
import q.f;
import q.i;

/* loaded from: classes.dex */
class ViewInfoStore {
    private static final boolean DEBUG = false;
    final i<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap = new i<>();
    final f<RecyclerView.ViewHolder> mOldChangedHolders = new f<>();

    static class InfoRecord {
        static final int FLAG_APPEAR = 2;
        static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
        static final int FLAG_APPEAR_PRE_AND_POST = 14;
        static final int FLAG_DISAPPEARED = 1;
        static final int FLAG_POST = 8;
        static final int FLAG_PRE = 4;
        static final int FLAG_PRE_AND_POST = 12;
        static e<InfoRecord> sPool = new D.f(20);
        int flags;
        RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
        RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        private InfoRecord() {
        }

        static void drainCache() {
            while (sPool.b() != null) {
            }
        }

        static InfoRecord obtain() {
            InfoRecord infoRecordB = sPool.b();
            return infoRecordB == null ? new InfoRecord() : infoRecordB;
        }

        static void recycle(InfoRecord infoRecord) {
            infoRecord.flags = 0;
            infoRecord.preInfo = null;
            infoRecord.postInfo = null;
            sPool.a(infoRecord);
        }
    }

    interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processDisappeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processPersistent(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void unused(RecyclerView.ViewHolder viewHolder);
    }

    ViewInfoStore() {
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder viewHolder, int i5) {
        InfoRecord infoRecordJ;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int iD = this.mLayoutHolderMap.d(viewHolder);
        if (iD >= 0 && (infoRecordJ = this.mLayoutHolderMap.j(iD)) != null) {
            int i6 = infoRecordJ.flags;
            if ((i6 & i5) != 0) {
                int i7 = (~i5) & i6;
                infoRecordJ.flags = i7;
                if (i5 == 4) {
                    itemHolderInfo = infoRecordJ.preInfo;
                } else {
                    if (i5 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    itemHolderInfo = infoRecordJ.postInfo;
                }
                if ((i7 & 12) == 0) {
                    this.mLayoutHolderMap.h(iD);
                    InfoRecord.recycle(infoRecordJ);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecordObtain);
        }
        infoRecordObtain.flags |= 2;
        infoRecordObtain.preInfo = itemHolderInfo;
    }

    void addToDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecordObtain);
        }
        infoRecordObtain.flags |= 1;
    }

    void addToOldChangeHolders(long j5, RecyclerView.ViewHolder viewHolder) {
        this.mOldChangedHolders.j(j5, viewHolder);
    }

    void addToPostLayout(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecordObtain);
        }
        infoRecordObtain.postInfo = itemHolderInfo;
        infoRecordObtain.flags |= 8;
    }

    void addToPreLayout(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, infoRecordObtain);
        }
        infoRecordObtain.preInfo = itemHolderInfo;
        infoRecordObtain.flags |= 4;
    }

    void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.b();
    }

    RecyclerView.ViewHolder getFromOldChangeHolders(long j5) {
        return this.mOldChangedHolders.g(j5);
    }

    boolean isDisappearing(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        return (infoRecord == null || (infoRecord.flags & 1) == 0) ? false : true;
    }

    boolean isInPreLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        return (infoRecord == null || (infoRecord.flags & 4) == 0) ? false : true;
    }

    void onDetach() {
        InfoRecord.drainCache();
    }

    public void onViewDetached(RecyclerView.ViewHolder viewHolder) {
        removeFromDisappearedInLayout(viewHolder);
    }

    RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder viewHolder) {
        return popFromLayoutStep(viewHolder, 8);
    }

    RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder viewHolder) {
        return popFromLayoutStep(viewHolder, 4);
    }

    void process(ProcessCallback processCallback) {
        for (int size = this.mLayoutHolderMap.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder viewHolderF = this.mLayoutHolderMap.f(size);
            InfoRecord infoRecordH = this.mLayoutHolderMap.h(size);
            int i5 = infoRecordH.flags;
            if ((i5 & 3) == 3) {
                processCallback.unused(viewHolderF);
            } else if ((i5 & 1) != 0) {
                RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = infoRecordH.preInfo;
                if (itemHolderInfo == null) {
                    processCallback.unused(viewHolderF);
                } else {
                    processCallback.processDisappeared(viewHolderF, itemHolderInfo, infoRecordH.postInfo);
                }
            } else if ((i5 & 14) == 14) {
                processCallback.processAppeared(viewHolderF, infoRecordH.preInfo, infoRecordH.postInfo);
            } else if ((i5 & 12) == 12) {
                processCallback.processPersistent(viewHolderF, infoRecordH.preInfo, infoRecordH.postInfo);
            } else if ((i5 & 4) != 0) {
                processCallback.processDisappeared(viewHolderF, infoRecordH.preInfo, null);
            } else if ((i5 & 8) != 0) {
                processCallback.processAppeared(viewHolderF, infoRecordH.preInfo, infoRecordH.postInfo);
            }
            InfoRecord.recycle(infoRecordH);
        }
    }

    void removeFromDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.flags &= -2;
    }

    void removeViewHolder(RecyclerView.ViewHolder viewHolder) {
        int iP = this.mOldChangedHolders.p() - 1;
        while (true) {
            if (iP < 0) {
                break;
            }
            if (viewHolder == this.mOldChangedHolders.q(iP)) {
                this.mOldChangedHolders.l(iP);
                break;
            }
            iP--;
        }
        InfoRecord infoRecordRemove = this.mLayoutHolderMap.remove(viewHolder);
        if (infoRecordRemove != null) {
            InfoRecord.recycle(infoRecordRemove);
        }
    }
}
