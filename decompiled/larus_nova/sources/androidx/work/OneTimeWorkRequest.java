package androidx.work;

import android.os.Build;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class OneTimeWorkRequest extends WorkRequest {

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        @Override // androidx.work.WorkRequest.Builder
        public Builder getThis() {
            return this;
        }

        @Override // androidx.work.WorkRequest.Builder
        public OneTimeWorkRequest buildInternal() {
            if (this.mBackoffCriteriaSet == false) goto L12;
            if (Build.VERSION.SDK_INT < 23) goto L12;
            if (this.mWorkSpec.constraints.requiresDeviceIdle() == false) goto L12;
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        L12:
            return new OneTimeWorkRequest(this);
        }

        @Override // androidx.work.WorkRequest.Builder
        public /* bridge */ /* synthetic */ WorkRequest.Builder getThis() {
            return getThis();
        }

        @Override // androidx.work.WorkRequest.Builder
        public /* bridge */ /* synthetic */ WorkRequest buildInternal() {
            return buildInternal();
        }

        public Builder(Class<? extends ListenableWorker> r100) {
            super(r100);
            WorkSpec r101 = this.mWorkSpec;
            r101.inputMergerClassName = OverwritingInputMerger.class.getName();
        }

        public Builder setInputMerger(Class<? extends InputMerger> r100) {
            WorkSpec r101 = this.mWorkSpec;
            r101.inputMergerClassName = r100.getName();
            return this;
        }
    }

    public OneTimeWorkRequest(Builder r100) {
        super(r100.mId, r100.mWorkSpec, r100.mTags);
    }

    public static List<OneTimeWorkRequest> from(List<Class<? extends ListenableWorker>> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Class<? extends ListenableWorker>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(new Builder(r102.next()).build());
        goto L4
    L6:
        return r101;
    }

    public static OneTimeWorkRequest from(Class<? extends ListenableWorker> r100) {
        return new Builder(r100).build();
    }
}
