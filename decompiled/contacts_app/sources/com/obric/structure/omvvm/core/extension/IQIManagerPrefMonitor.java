package com.obric.structure.omvvm.core.extension;

import com.bytedance.apm.constant.PerfConsts;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: IQIManagerPrefMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0017\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\bH&J\b\u0010\u0013\u001a\u00020\u0003H&J0\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u0016H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\bH&J\b\u0010\u001a\u001a\u00020\u001bH&¨\u0006\u001c"}, d2 = {"Lcom/obric/structure/omvvm/core/extension/IQIManagerPrefMonitor;", "", "onAllModulesVisibilityChanged", "", "onBindFinish", "onBindInner", "onHandleConflictEnd", "timeNano", "", "onModuleInitialized", "timeNs", "(Ljava/lang/Long;)V", "onMustBindEnd", "onMustBindStart", PerfConsts.PERF_DISK_FILE_SIZE, "", "onSubModuleBindFinish", "moduleName", "", "onUnbind", "onUnbindFinish", "moduleCreatedTimeRecord", "", "moduleVisibilityTimeRecord", "onVisibilityCalculationEnd", "timeUs", "shouldSample", "", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IQIManagerPrefMonitor {
    void onAllModulesVisibilityChanged();

    void onBindFinish();

    void onBindInner();

    void onHandleConflictEnd(long r1);

    void onModuleInitialized(Long r1);

    void onMustBindEnd();

    void onMustBindStart(int r1);

    void onSubModuleBindFinish(String r1, long r2);

    void onUnbind();

    void onUnbindFinish(Map<String, Long> r1, Map<String, Long> r2);

    void onVisibilityCalculationEnd(long r1);

    boolean shouldSample();
}
