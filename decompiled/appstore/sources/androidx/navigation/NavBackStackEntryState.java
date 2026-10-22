package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 *2\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ/\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0015R\u0019\u0010$\u001a\u0004\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'¨\u0006,"}, d2 = {"Landroidx/navigation/NavBackStackEntryState;", "Landroid/os/Parcelable;", "Landroidx/navigation/NavBackStackEntry;", "entry", "<init>", "(Landroidx/navigation/NavBackStackEntry;)V", "Landroid/os/Parcel;", "inParcel", "(Landroid/os/Parcel;)V", "Landroid/content/Context;", "context", "Landroidx/navigation/NavDestination;", "destination", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/navigation/e;", "viewModel", "instantiate", "(Landroid/content/Context;Landroidx/navigation/NavDestination;Landroidx/lifecycle/Lifecycle$State;Landroidx/navigation/e;)Landroidx/navigation/NavBackStackEntry;", "", "describeContents", "()I", "parcel", "i", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "destinationId", "I", "getDestinationId", "Landroid/os/Bundle;", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "savedState", "getSavedState", "Companion", "b", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"BanParcelableUsage"})
public final class NavBackStackEntryState implements Parcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = null;

    @NotNull
    public static final b Companion = null;

    @Nullable
    private final Bundle args;
    private final int destinationId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f3744id;

    @NotNull
    private final Bundle savedState;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public NavBackStackEntryState a(Parcel r10) {
            kotlin.jvm.internal.q.g(r10, "inParcel");
            return new NavBackStackEntryState(r10);
        }

        public NavBackStackEntryState[] b(int r10) {
            return new NavBackStackEntryState[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        Companion = new b(null);
        CREATOR = new a();
    }

    public NavBackStackEntryState(@NotNull NavBackStackEntry r10) {
        kotlin.jvm.internal.q.g(r10, "entry");
        this.f3744id = r10.g();
        this.destinationId = r10.f().i();
        this.args = r10.d();
        Bundle r11 = new Bundle();
        this.savedState = r11;
        r10.i(r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Bundle getArgs() {
        return this.args;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    @NotNull
    public final String getId() {
        return this.f3744id;
    }

    @NotNull
    public final Bundle getSavedState() {
        return this.savedState;
    }

    @NotNull
    public final NavBackStackEntry instantiate(@NotNull Context r10, @NotNull NavDestination r11, @NotNull Lifecycle.State r12, @Nullable e r13) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "destination");
        kotlin.jvm.internal.q.g(r12, "hostLifecycleState");
        Bundle r14 = this.args;
        if (r14 == null) goto L6;
        r14.setClassLoader(r10.getClassLoader());
    L5:
        Bundle r15 = r14;
        return NavBackStackEntry.f3729n.a(r10, r11, r15, r12, r13, this.f3744id, this.savedState);
    L6:
        r14 = null;
        goto L5
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "parcel");
        r10.writeString(this.f3744id);
        r10.writeInt(this.destinationId);
        r10.writeBundle(this.args);
        r10.writeBundle(this.savedState);
    }

    public NavBackStackEntryState(@NotNull Parcel r10) {
        kotlin.jvm.internal.q.g(r10, "inParcel");
        String r11 = r10.readString();
        kotlin.jvm.internal.q.d(r11);
        this.f3744id = r11;
        this.destinationId = r10.readInt();
        this.args = r10.readBundle(NavBackStackEntryState.class.getClassLoader());
        Bundle r12 = r10.readBundle(NavBackStackEntryState.class.getClassLoader());
        kotlin.jvm.internal.q.d(r12);
        this.savedState = r12;
    }
}
