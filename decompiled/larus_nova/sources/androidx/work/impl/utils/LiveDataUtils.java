package androidx.work.impl.utils;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: loaded from: classes28.dex */
public class LiveDataUtils {

    /* JADX INFO: Add missing generic type declarations: [In] */
    /* JADX INFO: renamed from: androidx.work.impl.utils.LiveDataUtils$1, reason: invalid class name */
    public class AnonymousClass1<In> implements Observer<In> {
        Out mCurrentOutput;
        final /* synthetic */ Object val$lock;
        final /* synthetic */ Function val$mappingMethod;
        final /* synthetic */ MediatorLiveData val$outputLiveData;
        final /* synthetic */ TaskExecutor val$workTaskExecutor;

        @Override // androidx.lifecycle.Observer
        public void onChanged(final In r100) {
            this.val$workTaskExecutor.executeOnBackgroundThread(new RunnableC02011(this, r100));
        }

        public AnonymousClass1(TaskExecutor r100, Object r101, Function r102, MediatorLiveData r103) {
            this.val$workTaskExecutor = r100;
            this.val$lock = r101;
            this.val$mappingMethod = r102;
            this.val$outputLiveData = r103;
            this.mCurrentOutput = null;
        }
    }

    private LiveDataUtils() {
    }

    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(LiveData<In> r100, Function<In, Out> r101, TaskExecutor r102) {
        Object r103 = new Object();
        MediatorLiveData r104 = new MediatorLiveData();
        r104.addSource(r100, new AnonymousClass1(r102, r103, r101, r104));
        return r104;
    }
}
