package androidx.recyclerview.widget;

import android.view.ViewGroup;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static final String TAG = "ConcatAdapter";
    private final ConcatAdapterController mController;

    public static final class Config {
        public static final Config DEFAULT = null;
        public final boolean isolateViewTypes;
        public final StableIdMode stableIdMode;

        public static final class Builder {
            private boolean mIsolateViewTypes;
            private StableIdMode mStableIdMode;

            public Config build() {
                return new Config(this.mIsolateViewTypes, this.mStableIdMode);
            }

            public Builder() {
                Config r100 = Config.DEFAULT;
                this.mIsolateViewTypes = r100.isolateViewTypes;
                this.mStableIdMode = r100.stableIdMode;
            }

            public Builder setIsolateViewTypes(boolean r100) {
                this.mIsolateViewTypes = r100;
                return this;
            }

            public Builder setStableIdMode(StableIdMode r100) {
                this.mStableIdMode = r100;
                return this;
            }
        }

        public static final enum StableIdMode extends Enum<StableIdMode> {
            private static final /* synthetic */ StableIdMode[] $VALUES = null;
            public static final StableIdMode ISOLATED_STABLE_IDS = null;
            public static final StableIdMode NO_STABLE_IDS = null;
            public static final StableIdMode SHARED_STABLE_IDS = null;

            static {
                StableIdMode r100 = new StableIdMode("NO_STABLE_IDS", 0);
                NO_STABLE_IDS = r100;
                StableIdMode r101 = new StableIdMode("ISOLATED_STABLE_IDS", 1);
                ISOLATED_STABLE_IDS = r101;
                StableIdMode r102 = new StableIdMode("SHARED_STABLE_IDS", 2);
                SHARED_STABLE_IDS = r102;
                $VALUES = new StableIdMode[]{r100, r101, r102};
            }

            public static StableIdMode[] values() {
                return (StableIdMode[]) $VALUES.clone();
            }

            public static StableIdMode valueOf(String r100) {
                return (StableIdMode) a.a(StableIdMode.class, r100);
            }

            private StableIdMode(String r100, int r101) {
                super(r100, r101);
            }
        }

        static {
            DEFAULT = new Config(true, StableIdMode.NO_STABLE_IDS);
        }

        public Config(boolean r100, StableIdMode r101) {
            this.isolateViewTypes = r100;
            this.stableIdMode = r101;
        }
    }

    public List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getAdapters() {
        return Collections.unmodifiableList(this.mController.getCopyOfAdapters());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mController.getTotalCount();
    }

    public ConcatAdapter(List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r100) {
        this(Config.DEFAULT, r100);
    }

    public boolean addAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100) {
        return this.mController.addAdapter(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r100) {
        return this.mController.getItemId(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        return this.mController.getItemViewType(r100);
    }

    public void internalSetStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy r100) {
        super.setStateRestorationPolicy(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r100) {
        this.mController.onAttachedToRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView r100) {
        this.mController.onDetachedFromRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        return this.mController.onFailedToRecycleView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        this.mController.onViewAttachedToWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        this.mController.onViewDetachedFromWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder r100) {
        this.mController.onViewRecycled(r100);
    }

    public boolean removeAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100) {
        return this.mController.removeAdapter(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean r100) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy r100) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    @SafeVarargs
    public ConcatAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... r100) {
        this(Config.DEFAULT, r100);
    }

    public ConcatAdapter(Config r100, List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r101) {
        this.mController = new ConcatAdapterController(this, r100);
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        addAdapter(r102.next());
        goto L4
    L6:
        super.setHasStableIds(this.mController.hasStableIds());
    }

    public boolean addAdapter(int r100, RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r101) {
        return this.mController.addAdapter(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        this.mController.onBindViewHolder(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return this.mController.onCreateViewHolder(r100, r101);
    }

    @SafeVarargs
    public ConcatAdapter(Config r100, RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... r101) {
        this(r100, Arrays.asList(r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int findRelativeAdapterPositionIn(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100, RecyclerView.ViewHolder r101, int r102) {
        return this.mController.getLocalAdapterPosition(r100, r101, r102);
    }
}
