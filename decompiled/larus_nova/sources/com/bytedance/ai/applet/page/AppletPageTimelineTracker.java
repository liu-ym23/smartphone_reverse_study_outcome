package com.bytedance.ai.applet.page;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.monitor.timeline.OpenFrom;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u001c\u0010\u000f\u001a\u00020\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u001a\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\rJ\u0006\u0010\u0018\u001a\u00020\u0016J\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/applet/page/AppletPageTimelineTracker;", "Landroid/os/Parcelable;", "traceId", "", "<init>", "(Ljava/lang/String;)V", "hasFinished", "", "getHasFinished$annotations", "()V", "hasReported", "getHasReported$annotations", "onPageStart", "", "onPageFinished", "onTimingSetup", "timingInfo", "", "", LynxVideoManagerLite.EVENT_ON_ERROR, "message", "errorCode", "", "report", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPageTimelineTracker implements Parcelable {
    public static final Parcelable.Creator<AppletPageTimelineTracker> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f34891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f34892c;

    public static final class a {
        public static AppletPageTimelineTracker a(String r100, String r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            Intrinsics.checkNotNullParameter(r110, "url");
            Intrinsics.checkNotNullParameter(r111, "renderType");
            i1 r101 = y0.f512051a;
            OpenFrom r102 = OpenFrom.APPLET_APP;
            String r103 = y0.a(r102.getFrom(), r100, "");
            AppletPageTimelineTracker r104 = new AppletPageTimelineTracker(r103);
            y0.d(r103, r110, "full", r102.getFrom(), r100, r111);
            return r104;
        }
    }

    public static final class b implements Parcelable.Creator<AppletPageTimelineTracker> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppletPageTimelineTracker createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new AppletPageTimelineTracker(r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final AppletPageTimelineTracker[] newArray(int r100) {
            return new AppletPageTimelineTracker[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f34890a);
    }

    public AppletPageTimelineTracker(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        this.f34890a = r100;
    }

    public final void a(String r100, int r101) {
        if (this.f34891b == false) goto L5;
        return;
    L5:
        if (this.f34892c == true) goto L13;
        i1 r102 = y0.f512051a;
        String r103 = this.f34890a;
        if (r100 != null) goto L10;
        r100 = "Applet page load error";
    L10:
        y0.b(r103, r100, r101, "applet_page_timeline_full");
        this.f34891b = true;
        this.f34892c = true;
        y0.o(this.f34890a, "applet_page_timeline_full");
        return;
    }
}
