package androidx.navigation;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001aB1\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Landroidx/navigation/NavArgument;", "", "type", "Landroidx/navigation/NavType;", "isNullable", "", "defaultValue", "defaultValuePresent", "(Landroidx/navigation/NavType;ZLjava/lang/Object;Z)V", "getDefaultValue", "()Ljava/lang/Object;", "isDefaultValuePresent", "()Z", "getType", "()Landroidx/navigation/NavType;", "equals", "other", "hashCode", "", "putDefaultValue", "", "name", "", "bundle", "Landroid/os/Bundle;", "verify", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavArgument {
    private final Object defaultValue;
    private final boolean isDefaultValuePresent;
    private final boolean isNullable;
    private final NavType<Object> type;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\r\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u000e0\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavArgument$Builder;", "", "()V", "defaultValue", "defaultValuePresent", "", "isNullable", "type", "Landroidx/navigation/NavType;", "build", "Landroidx/navigation/NavArgument;", "setDefaultValue", "setIsNullable", "setType", ExifInterface.GPS_DIRECTION_TRUE, "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private Object defaultValue;
        private boolean defaultValuePresent;
        private boolean isNullable;
        private NavType<Object> type;

        public final NavArgument build() {
            NavType<Object> r100 = this.type;
            if (r100 != null) goto L6;
            r100 = NavType.Companion.inferFromValueType(this.defaultValue);
        L6:
            return new NavArgument(r100, this.isNullable, this.defaultValue, this.defaultValuePresent);
        }

        public Builder() {
        }

        public final Builder setDefaultValue(Object r100) {
            this.defaultValue = r100;
            this.defaultValuePresent = true;
            return this;
        }

        public final Builder setIsNullable(boolean r100) {
            this.isNullable = r100;
            return this;
        }

        public final <T> Builder setType(NavType<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.type = r100;
            return this;
        }
    }

    public int hashCode() {
        int r100 = ((((this.type.hashCode() * 31) + (this.isNullable ? 1 : 0)) * 31) + (this.isDefaultValuePresent ? 1 : 0)) * 31;
        Object r101 = this.defaultValue;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final NavType<Object> getType() {
        return this.type;
    }

    public final boolean isDefaultValuePresent() {
        return this.isDefaultValuePresent;
    }

    public final boolean isNullable() {
        return this.isNullable;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L27:
        return false;
    L8:
        if (Intrinsics.areEqual(NavArgument.class, r100.getClass()) == false) goto L27;
        NavArgument r101 = (NavArgument) r100;
        if (this.isNullable == r101.isNullable) goto L14;
        return false;
    L14:
        if (this.isDefaultValuePresent == r101.isDefaultValuePresent) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L19;
        return false;
    L19:
        Object r102 = this.defaultValue;
        if (r102 == null) goto L23;
        return Intrinsics.areEqual(r102, r101.defaultValue);
    L23:
        if (r101.defaultValue == null) goto L29;
        return false;
    L29:
        return true;
    }

    public final void putDefaultValue(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        if (this.isDefaultValuePresent == false) goto L6;
        this.type.put(r101, r100, this.defaultValue);
        return;
    }

    public final boolean verify(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        if (this.isNullable == false) goto L5;
    L13:
        this.type.get(r101, r100);     // Catch: ClassCastException -> L12
        return true;
    L12:
        return false;
    L5:
        if (r101.containsKey(r100) == false) goto L13;
        if (r101.get(r100) != null) goto L13;
        return false;
    }

    public NavArgument(NavType<Object> r100, boolean r101, Object r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        boolean r104 = false;
        if (r100.isNullableAllowed() == true) goto L7;
        if (r101 == false) goto L7;
        boolean r105 = false;
    L8:
        if (r105 == false) goto L19;
        if (r101 == true) goto L12;
        if (r103 == false) goto L12;
        if (r102 != null) goto L12;
    L13:
        if (r104 == false) goto L17;
        this.type = r100;
        this.isNullable = r101;
        this.defaultValue = r102;
        this.isDefaultValuePresent = r103;
        return;
    L17:
        throw new IllegalArgumentException(("Argument with type " + r100.getName() + " has null value but is not nullable.").toString());
    L12:
        r104 = true;
        goto L13
    L19:
        throw new IllegalArgumentException(Intrinsics.stringPlus(r100.getName(), " does not allow nullable values").toString());
    L7:
        r105 = true;
        goto L8
    }
}
