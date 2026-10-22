package androidx.camera.core.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class QuirkSettings {
    private final boolean mEnabledWhenDeviceHasQuirk;
    private final Set<Class<? extends Quirk>> mForceDisabledQuirks;
    private final Set<Class<? extends Quirk>> mForceEnabledQuirks;

    /* JADX INFO: renamed from: androidx.camera.core.impl.QuirkSettings$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private boolean mEnabledWhenDeviceHasQuirk;
        private Set<Class<? extends Quirk>> mForceDisabledQuirks;
        private Set<Class<? extends Quirk>> mForceEnabledQuirks;

        public QuirkSettings build() {
            return new QuirkSettings(this.mEnabledWhenDeviceHasQuirk, this.mForceEnabledQuirks, this.mForceDisabledQuirks, null);
        }

        public Builder() {
            this.mEnabledWhenDeviceHasQuirk = true;
        }

        public Builder forceDisableQuirks(Set<Class<? extends Quirk>> r100) {
            this.mForceDisabledQuirks = new HashSet(r100);
            return this;
        }

        public Builder forceEnableQuirks(Set<Class<? extends Quirk>> r100) {
            this.mForceEnabledQuirks = new HashSet(r100);
            return this;
        }

        public Builder setEnabledWhenDeviceHasQuirk(boolean r100) {
            this.mEnabledWhenDeviceHasQuirk = r100;
            return this;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mEnabledWhenDeviceHasQuirk), this.mForceEnabledQuirks, this.mForceDisabledQuirks});
    }

    public static QuirkSettings withAllQuirksDisabled() {
        return new Builder().setEnabledWhenDeviceHasQuirk(false).build();
    }

    public static QuirkSettings withDefaultBehavior() {
        return new Builder().setEnabledWhenDeviceHasQuirk(true).build();
    }

    public Set<Class<? extends Quirk>> getForceDisabledQuirks() {
        return Collections.unmodifiableSet(this.mForceDisabledQuirks);
    }

    public Set<Class<? extends Quirk>> getForceEnabledQuirks() {
        return Collections.unmodifiableSet(this.mForceEnabledQuirks);
    }

    public String toString() {
        return "QuirkSettings{enabledWhenDeviceHasQuirk=" + this.mEnabledWhenDeviceHasQuirk + ", forceEnabledQuirks=" + this.mForceEnabledQuirks + ", forceDisabledQuirks=" + this.mForceDisabledQuirks + '}';
    }

    public boolean isEnabledWhenDeviceHasQuirk() {
        return this.mEnabledWhenDeviceHasQuirk;
    }

    public static QuirkSettings withQuirksForceDisabled(Set<Class<? extends Quirk>> r100) {
        return new Builder().forceDisableQuirks(r100).build();
    }

    public static QuirkSettings withQuirksForceEnabled(Set<Class<? extends Quirk>> r100) {
        return new Builder().forceEnableQuirks(r100).build();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof QuirkSettings) == true) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        QuirkSettings r101 = (QuirkSettings) r100;
        if (this.mEnabledWhenDeviceHasQuirk == r101.mEnabledWhenDeviceHasQuirk) goto L11;
        return false;
    L11:
        if (Objects.equals(this.mForceEnabledQuirks, r101.mForceEnabledQuirks) == true) goto L13;
        return false;
    L13:
        if (Objects.equals(this.mForceDisabledQuirks, r101.mForceDisabledQuirks) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public boolean shouldEnableQuirk(Class<? extends Quirk> r100, boolean r101) {
        if (this.mForceEnabledQuirks.contains(r100) == false) goto L6;
        return true;
    L6:
        if (this.mForceDisabledQuirks.contains(r100) == false) goto L9;
        return false;
    L9:
        if (this.mEnabledWhenDeviceHasQuirk == false) goto L12;
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    }

    private QuirkSettings(boolean r100, Set<Class<? extends Quirk>> r101, Set<Class<? extends Quirk>> r102) {
        this.mEnabledWhenDeviceHasQuirk = r100;
        if (r101 != null) goto L5;
        Set<Class<? extends Quirk>> r103 = Collections.emptySet();
    L6:
        this.mForceEnabledQuirks = r103;
        if (r102 != null) goto L9;
        Set<Class<? extends Quirk>> r104 = Collections.emptySet();
    L10:
        this.mForceDisabledQuirks = r104;
        return;
    L9:
        r104 = new HashSet(r102);
        goto L10
    L5:
        r103 = new HashSet(r101);
        goto L6
    }

    public /* synthetic */ QuirkSettings(boolean r100, Set r101, Set r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }
}
