package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;

/* JADX INFO: loaded from: classes17.dex */
interface StableIdStorage {

    public static class IsolatedStableIdStorage implements StableIdStorage {
        long mNextStableId;

        public class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> mLocalToGlobalLookup;
            final /* synthetic */ IsolatedStableIdStorage this$0;

            public WrapperStableIdLookup(IsolatedStableIdStorage r100) {
                this.this$0 = r100;
                this.mLocalToGlobalLookup = new LongSparseArray();
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long r100) {
                Long r101 = this.mLocalToGlobalLookup.get(r100);
                if (r101 != null) goto L6;
                r101 = Long.valueOf(this.this$0.obtainId());
                this.mLocalToGlobalLookup.put(r100, r101);
            L6:
                return r101.longValue();
            }
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup createStableIdLookup() {
            return new WrapperStableIdLookup(this);
        }

        public long obtainId() {
            long r100 = this.mNextStableId;
            this.mNextStableId = 1 + r100;
            return r100;
        }

        public IsolatedStableIdStorage() {
            this.mNextStableId = 0;
        }
    }

    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup;

        public NoStableIdStorage() {
            this.mNoIdLookup = new AnonymousClass1(this);
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup;

        public SharedPoolStableIdStorage() {
            this.mSameIdLookup = new AnonymousClass1(this);
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    public interface StableIdLookup {
        long localToGlobal(long r100);
    }

    StableIdLookup createStableIdLookup();
}
