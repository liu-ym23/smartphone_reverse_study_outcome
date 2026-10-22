package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import b.C0354a;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Landroidx/activity/result/IntentSenderRequest;", "Landroid/os/Parcelable;", "androidx/activity/result/i", "y1/f", "activity_release"}, k = 1, mv = {1, 8, 0})
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new C0354a(12);

    /* renamed from: a, reason: collision with root package name */
    public final IntentSender f2412a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f2413b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2414c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2415d;

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i4, int i5) {
        Intrinsics.checkNotNullParameter(intentSender, "intentSender");
        this.f2412a = intentSender;
        this.f2413b = intent;
        this.f2414c = i4;
        this.f2415d = i5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i4) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.f2412a, i4);
        dest.writeParcelable(this.f2413b, i4);
        dest.writeInt(this.f2414c);
        dest.writeInt(this.f2415d);
    }
}
