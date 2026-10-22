package com.bytedance.ai.applet.app.foundation;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.RouteOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction;", "Landroid/os/Parcelable;", "<init>", "()V", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "Launch", "NavigateTo", "RedirectTo", "ReLaunch", "OpenPage", "Lcom/bytedance/ai/applet/app/foundation/RouteAction$Launch;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction$NavigateTo;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction$OpenPage;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction$ReLaunch;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction$RedirectTo;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class RouteAction implements Parcelable {

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction$Launch;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "<init>", "(Lcom/bytedance/ai/applet/app/base/RouteOptions;)V", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Launch extends RouteAction {
        public static final Parcelable.Creator<Launch> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RouteOptions f34190a;

        public static final class a implements Parcelable.Creator<Launch> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Launch createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                if (r100.readInt() != 0) goto L5;
                RouteOptions r101 = null;
            L7:
                return new Launch(r101);
            L5:
                r101 = RouteOptions.CREATOR.createFromParcel(r100);
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final Launch[] newArray(int r100) {
                return new Launch[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public Launch() {
            this(null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Launch) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f34190a, ((Launch) r100).f34190a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            RouteOptions r100 = this.f34190a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Launch(options=" + this.f34190a + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            RouteOptions r102 = this.f34190a;
            if (r102 != null) goto L5;
            r100.writeInt(0);
            return;
        L5:
            r100.writeInt(1);
            r102.writeToParcel(r100, r101);
        }

        @Override // com.bytedance.ai.applet.app.foundation.RouteAction
        public final RouteOptions a() {
            return this.f34190a;
        }

        public Launch(RouteOptions r100) {
            this.f34190a = r100;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction$NavigateTo;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", "url", "", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)V", "getUrl", "()Ljava/lang/String;", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NavigateTo extends RouteAction {
        public static final Parcelable.Creator<NavigateTo> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RouteOptions f34192b;

        public static final class a implements Parcelable.Creator<NavigateTo> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final NavigateTo createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                String r101 = r100.readString();
                if (r100.readInt() != 0) goto L5;
                RouteOptions r102 = null;
            L7:
                return new NavigateTo(r101, r102);
            L5:
                r102 = RouteOptions.CREATOR.createFromParcel(r100);
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final NavigateTo[] newArray(int r100) {
                return new NavigateTo[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof NavigateTo) == true) goto L8;
            return false;
        L8:
            NavigateTo r101 = (NavigateTo) r100;
            if (Intrinsics.areEqual(this.f34191a, r101.f34191a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f34192b, r101.f34192b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f34191a.hashCode() * 31;
            RouteOptions r101 = this.f34192b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "NavigateTo(url=" + this.f34191a + ", options=" + this.f34192b + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.f34191a);
            RouteOptions r102 = this.f34192b;
            if (r102 != null) goto L5;
            r100.writeInt(0);
            return;
        L5:
            r100.writeInt(1);
            r102.writeToParcel(r100, r101);
        }

        @Override // com.bytedance.ai.applet.app.foundation.RouteAction
        public final RouteOptions a() {
            return this.f34192b;
        }

        public NavigateTo(String r100, RouteOptions r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f34191a = r100;
            this.f34192b = r101;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction$OpenPage;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", "url", "", "mode", "Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;Lcom/bytedance/ai/applet/app/base/RouteOptions;)V", "getUrl", "()Ljava/lang/String;", "getMode", "()Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpenPage extends RouteAction {
        public static final Parcelable.Creator<OpenPage> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ApplicationRouter.OpenPageMode f34194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RouteOptions f34195c;

        public static final class a implements Parcelable.Creator<OpenPage> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OpenPage createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                String r101 = r100.readString();
                ApplicationRouter.OpenPageMode r102 = ApplicationRouter.OpenPageMode.valueOf(r100.readString());
                if (r100.readInt() != 0) goto L5;
                RouteOptions r103 = null;
            L7:
                return new OpenPage(r101, r102, r103);
            L5:
                r103 = RouteOptions.CREATOR.createFromParcel(r100);
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final OpenPage[] newArray(int r100) {
                return new OpenPage[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof OpenPage) == true) goto L8;
            return false;
        L8:
            OpenPage r101 = (OpenPage) r100;
            if (Intrinsics.areEqual(this.f34193a, r101.f34193a) == true) goto L12;
            return false;
        L12:
            if (this.f34194b == r101.f34194b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f34195c, r101.f34195c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f34193a.hashCode() * 31) + this.f34194b.hashCode()) * 31;
            RouteOptions r101 = this.f34195c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "OpenPage(url=" + this.f34193a + ", mode=" + this.f34194b + ", options=" + this.f34195c + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.f34193a);
            r100.writeString(this.f34194b.name());
            RouteOptions r102 = this.f34195c;
            if (r102 != null) goto L5;
            r100.writeInt(0);
            return;
        L5:
            r100.writeInt(1);
            r102.writeToParcel(r100, r101);
        }

        @Override // com.bytedance.ai.applet.app.foundation.RouteAction
        public final RouteOptions a() {
            return this.f34195c;
        }

        public OpenPage(String r100, ApplicationRouter.OpenPageMode r101, RouteOptions r102) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "mode");
            this.f34193a = r100;
            this.f34194b = r101;
            this.f34195c = r102;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction$ReLaunch;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", "url", "", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)V", "getUrl", "()Ljava/lang/String;", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReLaunch extends RouteAction {
        public static final Parcelable.Creator<ReLaunch> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RouteOptions f34197b;

        public static final class a implements Parcelable.Creator<ReLaunch> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ReLaunch createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                String r101 = r100.readString();
                if (r100.readInt() != 0) goto L5;
                RouteOptions r102 = null;
            L7:
                return new ReLaunch(r101, r102);
            L5:
                r102 = RouteOptions.CREATOR.createFromParcel(r100);
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final ReLaunch[] newArray(int r100) {
                return new ReLaunch[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ReLaunch) == true) goto L8;
            return false;
        L8:
            ReLaunch r101 = (ReLaunch) r100;
            if (Intrinsics.areEqual(this.f34196a, r101.f34196a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f34197b, r101.f34197b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f34196a.hashCode() * 31;
            RouteOptions r101 = this.f34197b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ReLaunch(url=" + this.f34196a + ", options=" + this.f34197b + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.f34196a);
            RouteOptions r102 = this.f34197b;
            if (r102 != null) goto L5;
            r100.writeInt(0);
            return;
        L5:
            r100.writeInt(1);
            r102.writeToParcel(r100, r101);
        }

        @Override // com.bytedance.ai.applet.app.foundation.RouteAction
        public final RouteOptions a() {
            return this.f34197b;
        }

        public ReLaunch(String r100, RouteOptions r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f34196a = r100;
            this.f34197b = r101;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/RouteAction$RedirectTo;", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", "url", "", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)V", "getUrl", "()Ljava/lang/String;", "getOptions", "()Lcom/bytedance/ai/applet/app/base/RouteOptions;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RedirectTo extends RouteAction {
        public static final Parcelable.Creator<RedirectTo> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RouteOptions f34199b;

        public static final class a implements Parcelable.Creator<RedirectTo> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final RedirectTo createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                String r101 = r100.readString();
                if (r100.readInt() != 0) goto L5;
                RouteOptions r102 = null;
            L7:
                return new RedirectTo(r101, r102);
            L5:
                r102 = RouteOptions.CREATOR.createFromParcel(r100);
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final RedirectTo[] newArray(int r100) {
                return new RedirectTo[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RedirectTo) == true) goto L8;
            return false;
        L8:
            RedirectTo r101 = (RedirectTo) r100;
            if (Intrinsics.areEqual(this.f34198a, r101.f34198a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f34199b, r101.f34199b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f34198a.hashCode() * 31;
            RouteOptions r101 = this.f34199b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "RedirectTo(url=" + this.f34198a + ", options=" + this.f34199b + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.f34198a);
            RouteOptions r102 = this.f34199b;
            if (r102 != null) goto L5;
            r100.writeInt(0);
            return;
        L5:
            r100.writeInt(1);
            r102.writeToParcel(r100, r101);
        }

        @Override // com.bytedance.ai.applet.app.foundation.RouteAction
        public final RouteOptions a() {
            return this.f34199b;
        }

        public RedirectTo(String r100, RouteOptions r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f34198a = r100;
            this.f34199b = r101;
        }
    }

    public RouteAction() {
    }

    public RouteOptions a() {
        return null;
    }
}
