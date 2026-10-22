package com.bytedance.android.livesdk.live.extension.plugin.api.resourcemanager.downloader;

import android.text.TextUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 /2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0003012J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0017\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/resourcemanager/downloader/LiveWrappedTask;", "Ljava/io/Serializable;", "", "task", "", "compareTo", "", "o", "", "equals", "hashCode", "", "toString", "path", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "isOnlyWifi", "Z", "()Z", "setOnlyWifi", "(Z)V", "isSupportMultiThread", "setSupportMultiThread", "priority", "I", "getPriority", "()I", "setPriority", "(I)V", "isSupportProgressUpdate", "setSupportProgressUpdate", "", "progressUpdateInterval", "J", "getProgressUpdateInterval", "()J", "setProgressUpdateInterval", "(J)V", "autoRetryTimes", "getAutoRetryTimes", "setAutoRetryTimes", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "Priority", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveWrappedTask implements Serializable, Comparable<LiveWrappedTask> {
    public static final a Companion = null;
    public static final int DEFAULT = 5;
    public static final int HIGH = 10;
    public static final int LOW = 0;
    private static final long serialVersionUID = 0;
    private int autoRetryTimes;
    private boolean isOnlyWifi;
    private boolean isSupportMultiThread;
    private boolean isSupportProgressUpdate;
    private String path;
    private int priority;
    private long progressUpdateInterval;
    private String url;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/resourcemanager/downloader/LiveWrappedTask$Priority;", "", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Priority {
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f147295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f147296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f147297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f147298d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f147299e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f147300f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f147301g;

        public final LiveWrappedTask a() {
            if ((!TextUtils.isEmpty(this.f147295a)) == false) goto L11;
            if ((!TextUtils.isEmpty(this.f147296b)) == false) goto L9;
            return new LiveWrappedTask(this, null);
        L9:
            throw new IllegalArgumentException("url is empty".toString());
        L11:
            throw new IllegalArgumentException("path is empty".toString());
        }

        public b() {
            this.f147299e = 5;
            this.f147301g = 2000;
        }
    }

    static {
        Companion = new a();
        serialVersionUID = -8164149980876153200L;
    }

    public int hashCode() {
        return this.path.hashCode();
    }

    public String toString() {
        return "Task{path='" + this.path + "', url='" + this.url + "', isOnlyWifi=" + this.isOnlyWifi + ", isSupportMultiThread=" + this.isSupportMultiThread + ", priority=" + this.priority + '}';
    }

    public final int getAutoRetryTimes() {
        return this.autoRetryTimes;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final long getProgressUpdateInterval() {
        return this.progressUpdateInterval;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isOnlyWifi() {
        return this.isOnlyWifi;
    }

    public final boolean isSupportMultiThread() {
        return this.isSupportMultiThread;
    }

    public final boolean isSupportProgressUpdate() {
        return this.isSupportProgressUpdate;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(LiveWrappedTask r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        return r100.priority - this.priority;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((true ^ Intrinsics.areEqual(LiveWrappedTask.class, r100.getClass())) == false) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.path, ((LiveWrappedTask) r100).path);
    }

    public final void setAutoRetryTimes(int r100) {
        this.autoRetryTimes = r100;
    }

    public final void setOnlyWifi(boolean r100) {
        this.isOnlyWifi = r100;
    }

    public final void setPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.path = r100;
    }

    public final void setPriority(int r100) {
        this.priority = r100;
    }

    public final void setProgressUpdateInterval(long r100) {
        this.progressUpdateInterval = r100;
    }

    public final void setSupportMultiThread(boolean r100) {
        this.isSupportMultiThread = r100;
    }

    public final void setSupportProgressUpdate(boolean r100) {
        this.isSupportProgressUpdate = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(LiveWrappedTask r100) {
        return compareTo2(r100);
    }

    public LiveWrappedTask(b r100, DefaultConstructorMarker r101) {
        String r102 = r100.f147295a;
        Intrinsics.checkNotNull(r102);
        this.path = r102;
        String r103 = r100.f147296b;
        Intrinsics.checkNotNull(r103);
        this.url = r103;
        this.isOnlyWifi = r100.f147297c;
        this.isSupportMultiThread = r100.f147298d;
        this.priority = r100.f147299e;
        this.isSupportProgressUpdate = r100.f147300f;
        this.progressUpdateInterval = r100.f147301g;
        this.autoRetryTimes = 3;
    }
}
