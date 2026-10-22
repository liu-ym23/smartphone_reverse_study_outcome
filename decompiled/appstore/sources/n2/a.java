package n2;

import com.bytedance.apm.constant.ExceptionConsts;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22354a = "APM-Slardar";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f22355b = null;

    static {
        f22355b = Arrays.asList(new String[]{"block_monitor", "serious_block_monitor", "memory_object_monitor", "cpu_trace", "cpu_exception_trace", "drop_frame_stack", "cpu_trace", "battery_trace", ExceptionConsts.MONITOR_TYPE_ALLOC});
    }
}
