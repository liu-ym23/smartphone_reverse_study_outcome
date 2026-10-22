package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
interface ViewTypeStorage {

    public static class IsolatedViewTypeStorage implements ViewTypeStorage {
        SparseArray<NestedAdapterWrapper> mGlobalTypeToWrapper;
        int mNextViewType;

        public class WrapperViewTypeLookup implements ViewTypeLookup {
            private SparseIntArray mGlobalToLocalMapping;
            private SparseIntArray mLocalToGlobalMapping;
            final NestedAdapterWrapper mWrapper;
            final /* synthetic */ IsolatedViewTypeStorage this$0;

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                this.this$0.removeWrapper(this.mWrapper);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int globalToLocal(int r100) {
                int r101 = this.mGlobalToLocalMapping.indexOfKey(r100);
                if (r101 < 0) goto L7;
                return this.mGlobalToLocalMapping.valueAt(r101);
            L7:
                throw new IllegalStateException("requested global type " + r100 + " does not belong to the adapter:" + this.mWrapper.adapter);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int localToGlobal(int r100) {
                int r101 = this.mLocalToGlobalMapping.indexOfKey(r100);
                if (r101 > (-1)) goto L5;
                int r102 = this.this$0.obtainViewType(this.mWrapper);
                this.mLocalToGlobalMapping.put(r100, r102);
                this.mGlobalToLocalMapping.put(r102, r100);
                return r102;
            L5:
                return this.mLocalToGlobalMapping.valueAt(r101);
            }

            public WrapperViewTypeLookup(IsolatedViewTypeStorage r100, NestedAdapterWrapper r101) {
                this.this$0 = r100;
                this.mLocalToGlobalMapping = new SparseIntArray(1);
                this.mGlobalToLocalMapping = new SparseIntArray(1);
                this.mWrapper = r101;
            }
        }

        public IsolatedViewTypeStorage() {
            this.mGlobalTypeToWrapper = new SparseArray();
            this.mNextViewType = 0;
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public ViewTypeLookup createViewTypeWrapper(NestedAdapterWrapper r100) {
            return new WrapperViewTypeLookup(this, r100);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public NestedAdapterWrapper getWrapperForGlobalType(int r100) {
            NestedAdapterWrapper r101 = this.mGlobalTypeToWrapper.get(r100);
            if (r101 == null) goto L6;
            return r101;
        L6:
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r100);
        }

        public int obtainViewType(NestedAdapterWrapper r100) {
            int r101 = this.mNextViewType;
            this.mNextViewType = r101 + 1;
            this.mGlobalTypeToWrapper.put(r101, r100);
            return r101;
        }

        public void removeWrapper(NestedAdapterWrapper r100) {
            int r101 = this.mGlobalTypeToWrapper.size() - 1;
        L3:
            if (r101 < 0) goto L8;
            if (this.mGlobalTypeToWrapper.valueAt(r101) != r100) goto L7;
            this.mGlobalTypeToWrapper.removeAt(r101);
        L7:
            r101 = r101 - 1;
            goto L3
        }
    }

    public static class SharedIdRangeViewTypeStorage implements ViewTypeStorage {
        SparseArray<List<NestedAdapterWrapper>> mGlobalTypeToWrapper;

        public class WrapperViewTypeLookup implements ViewTypeLookup {
            final NestedAdapterWrapper mWrapper;
            final /* synthetic */ SharedIdRangeViewTypeStorage this$0;

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int globalToLocal(int r100) {
                return r100;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                this.this$0.removeWrapper(this.mWrapper);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int localToGlobal(int r100) {
                List<NestedAdapterWrapper> r101 = this.this$0.mGlobalTypeToWrapper.get(r100);
                if (r101 != null) goto L6;
                r101 = new ArrayList();
                this.this$0.mGlobalTypeToWrapper.put(r100, r101);
            L6:
                if (r101.contains(this.mWrapper) == true) goto L8;
                r101.add(this.mWrapper);
            L8:
                return r100;
            }

            public WrapperViewTypeLookup(SharedIdRangeViewTypeStorage r100, NestedAdapterWrapper r101) {
                this.this$0 = r100;
                this.mWrapper = r101;
            }
        }

        public SharedIdRangeViewTypeStorage() {
            this.mGlobalTypeToWrapper = new SparseArray();
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public ViewTypeLookup createViewTypeWrapper(NestedAdapterWrapper r100) {
            return new WrapperViewTypeLookup(this, r100);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public NestedAdapterWrapper getWrapperForGlobalType(int r100) {
            List<NestedAdapterWrapper> r101 = this.mGlobalTypeToWrapper.get(r100);
            if (r101 == null) goto L9;
            if (r101.isEmpty() == true) goto L9;
            return (NestedAdapterWrapper) ListProtector.get(r101, 0);
        L9:
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r100);
        }

        public void removeWrapper(NestedAdapterWrapper r100) {
            int r101 = this.mGlobalTypeToWrapper.size() - 1;
        L3:
            if (r101 < 0) goto L10;
            List<NestedAdapterWrapper> r102 = this.mGlobalTypeToWrapper.valueAt(r101);
            if (r102.remove(r100) == false) goto L9;
            if (r102.isEmpty() == false) goto L9;
            this.mGlobalTypeToWrapper.removeAt(r101);
        L9:
            r101 = r101 - 1;
            goto L3
        }
    }

    public interface ViewTypeLookup {
        void dispose();

        int globalToLocal(int r100);

        int localToGlobal(int r100);
    }

    ViewTypeLookup createViewTypeWrapper(NestedAdapterWrapper r100);

    NestedAdapterWrapper getWrapperForGlobalType(int r100);
}
