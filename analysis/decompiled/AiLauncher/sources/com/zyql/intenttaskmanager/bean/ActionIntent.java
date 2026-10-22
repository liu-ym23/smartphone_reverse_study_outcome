package com.zyql.intenttaskmanager.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/zyql/intenttaskmanager/bean/ActionIntent;", "Landroid/os/Parcelable;", "<init>", "()V", "OpenActivity", "OpenUri", "SendCommand", "Lcom/zyql/intenttaskmanager/bean/ActionIntent$OpenActivity;", "Lcom/zyql/intenttaskmanager/bean/ActionIntent$OpenUri;", "Lcom/zyql/intenttaskmanager/bean/ActionIntent$SendCommand;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ActionIntent implements Parcelable {

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\bJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/zyql/intenttaskmanager/bean/ActionIntent$OpenUri;", "Lcom/zyql/intenttaskmanager/bean/ActionIntent;", "", "uri", "<init>", "(Ljava/lang/String;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;)Lcom/zyql/intenttaskmanager/bean/ActionIntent$OpenUri;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUri", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OpenUri extends ActionIntent {
        public static final Parcelable.Creator<OpenUri> CREATOR = new a();
        private final String uri;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a implements Parcelable.Creator<OpenUri> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final OpenUri createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                return new OpenUri(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final OpenUri[] newArray(int i10) {
                return new OpenUri[i10];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenUri(String uri) {
            super(null);
            p.i(uri, "uri");
            this.uri = uri;
        }

        public static /* synthetic */ OpenUri copy$default(OpenUri openUri, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = openUri.uri;
            }
            return openUri.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUri() {
            return this.uri;
        }

        public final OpenUri copy(String uri) {
            p.i(uri, "uri");
            return new OpenUri(uri);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OpenUri) && p.d(this.uri, ((OpenUri) other).uri);
        }

        public final String getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return "OpenUri(uri=" + this.uri + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            p.i(dest, "dest");
            dest.writeString(this.uri);
        }
    }

    public /* synthetic */ ActionIntent(i iVar) {
        this();
    }

    private ActionIntent() {
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lcom/zyql/intenttaskmanager/bean/ActionIntent$SendCommand;", "Lcom/zyql/intenttaskmanager/bean/ActionIntent;", "", "action", "Landroid/os/Bundle;", "params", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Landroid/os/Bundle;)Lcom/zyql/intenttaskmanager/bean/ActionIntent$SendCommand;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAction", "Landroid/os/Bundle;", "getParams", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SendCommand extends ActionIntent {
        public static final Parcelable.Creator<SendCommand> CREATOR = new a();
        private final String action;
        private final Bundle params;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a implements Parcelable.Creator<SendCommand> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SendCommand createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                return new SendCommand(parcel.readString(), parcel.readBundle(SendCommand.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SendCommand[] newArray(int i10) {
                return new SendCommand[i10];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendCommand(String action, Bundle bundle) {
            super(null);
            p.i(action, "action");
            this.action = action;
            this.params = bundle;
        }

        public static /* synthetic */ SendCommand copy$default(SendCommand sendCommand, String str, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = sendCommand.action;
            }
            if ((i10 & 2) != 0) {
                bundle = sendCommand.params;
            }
            return sendCommand.copy(str, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAction() {
            return this.action;
        }

        /* renamed from: component2, reason: from getter */
        public final Bundle getParams() {
            return this.params;
        }

        public final SendCommand copy(String action, Bundle params) {
            p.i(action, "action");
            return new SendCommand(action, params);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendCommand)) {
                return false;
            }
            SendCommand sendCommand = (SendCommand) other;
            return p.d(this.action, sendCommand.action) && p.d(this.params, sendCommand.params);
        }

        public final String getAction() {
            return this.action;
        }

        public final Bundle getParams() {
            return this.params;
        }

        public int hashCode() {
            int iHashCode = this.action.hashCode() * 31;
            Bundle bundle = this.params;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "SendCommand(action=" + this.action + ", params=" + this.params + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            p.i(dest, "dest");
            dest.writeString(this.action);
            dest.writeBundle(this.params);
        }

        public /* synthetic */ SendCommand(String str, Bundle bundle, int i10, i iVar) {
            this(str, (i10 & 2) != 0 ? null : bundle);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J0\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J\u0010\u0010\u001a\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u0013R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010\u0016¨\u0006%"}, d2 = {"Lcom/zyql/intenttaskmanager/bean/ActionIntent$OpenActivity;", "Lcom/zyql/intenttaskmanager/bean/ActionIntent;", "", "packageName", "className", "Landroid/os/Bundle;", "extras", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/zyql/intenttaskmanager/bean/ActionIntent$OpenActivity;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPackageName", "getClassName", "Landroid/os/Bundle;", "getExtras", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OpenActivity extends ActionIntent {
        public static final Parcelable.Creator<OpenActivity> CREATOR = new a();
        private final String className;
        private final Bundle extras;
        private final String packageName;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a implements Parcelable.Creator<OpenActivity> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final OpenActivity createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                return new OpenActivity(parcel.readString(), parcel.readString(), parcel.readBundle(OpenActivity.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final OpenActivity[] newArray(int i10) {
                return new OpenActivity[i10];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenActivity(String packageName, String className, Bundle bundle) {
            super(null);
            p.i(packageName, "packageName");
            p.i(className, "className");
            this.packageName = packageName;
            this.className = className;
            this.extras = bundle;
        }

        public static /* synthetic */ OpenActivity copy$default(OpenActivity openActivity, String str, String str2, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = openActivity.packageName;
            }
            if ((i10 & 2) != 0) {
                str2 = openActivity.className;
            }
            if ((i10 & 4) != 0) {
                bundle = openActivity.extras;
            }
            return openActivity.copy(str, str2, bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getClassName() {
            return this.className;
        }

        /* renamed from: component3, reason: from getter */
        public final Bundle getExtras() {
            return this.extras;
        }

        public final OpenActivity copy(String packageName, String className, Bundle extras) {
            p.i(packageName, "packageName");
            p.i(className, "className");
            return new OpenActivity(packageName, className, extras);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenActivity)) {
                return false;
            }
            OpenActivity openActivity = (OpenActivity) other;
            return p.d(this.packageName, openActivity.packageName) && p.d(this.className, openActivity.className) && p.d(this.extras, openActivity.extras);
        }

        public final String getClassName() {
            return this.className;
        }

        public final Bundle getExtras() {
            return this.extras;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public int hashCode() {
            int iHashCode = ((this.packageName.hashCode() * 31) + this.className.hashCode()) * 31;
            Bundle bundle = this.extras;
            return iHashCode + (bundle == null ? 0 : bundle.hashCode());
        }

        public String toString() {
            return "OpenActivity(packageName=" + this.packageName + ", className=" + this.className + ", extras=" + this.extras + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            p.i(dest, "dest");
            dest.writeString(this.packageName);
            dest.writeString(this.className);
            dest.writeBundle(this.extras);
        }

        public /* synthetic */ OpenActivity(String str, String str2, Bundle bundle, int i10, i iVar) {
            this(str, str2, (i10 & 4) != 0 ? null : bundle);
        }
    }
}
