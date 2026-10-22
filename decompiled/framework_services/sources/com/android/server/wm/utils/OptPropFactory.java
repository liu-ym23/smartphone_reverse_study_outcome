package com.android.server.wm.utils;

import android.content.pm.PackageManager;
import android.util.Slog;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes3.dex */
public class OptPropFactory {
    private final PackageManager mPackageManager;
    private final String mPackageName;
    private final int mUserId;

    public static class OptProp {
        private static final String TAG = "OptProp";
        private static final int VALUE_FALSE = 0;
        private static final int VALUE_TRUE = 1;
        private static final int VALUE_UNDEFINED = -1;
        private static final int VALUE_UNSET = -2;
        private final BooleanSupplier mCondition;
        private final String mPropertyName;
        private int mValue;
        private final ThrowableBooleanSupplier mValueSupplier;

        @interface OptionalValue {
        }

        /* JADX INFO: renamed from: $r8$lambda$LEekx7VQZnJLvMrbsKhxYb-WShI, reason: not valid java name */
        public static /* synthetic */ boolean m10501$r8$lambda$LEekx7VQZnJLvMrbsKhxYbWShI() {
            return lambda$create$0();
        }

        /* JADX INFO: renamed from: -$$Nest$smcreate, reason: not valid java name */
        static /* bridge */ /* synthetic */ OptProp m10502$$Nest$smcreate(ThrowableBooleanSupplier r0, String r1) {
            return create(r0, r1);
        }

        /* JADX INFO: renamed from: -$$Nest$smcreate, reason: not valid java name */
        static /* bridge */ /* synthetic */ OptProp m10503$$Nest$smcreate(ThrowableBooleanSupplier r0, String r1, BooleanSupplier r2) {
            return create(r0, r1, r2);
        }

        private OptProp(ThrowableBooleanSupplier valueSupplier, String propertyName, BooleanSupplier condition) {
            this.mValue = -1;
            this.mValueSupplier = valueSupplier;
            this.mPropertyName = propertyName;
            this.mCondition = condition;
        }

        private static OptProp create(ThrowableBooleanSupplier valueSupplier, String propertyName) {
            return new OptProp(valueSupplier, propertyName, new OptPropFactory$OptProp$$ExternalSyntheticLambda0());
        }

        private static /* synthetic */ boolean lambda$create$0() {
            return true;
        }

        private static OptProp create(ThrowableBooleanSupplier valueSupplier, String propertyName, BooleanSupplier condition) {
            return new OptProp(valueSupplier, propertyName, condition);
        }

        public boolean isTrue() {
            if (this.mCondition.getAsBoolean() == true) goto L5;
        L7:
            return false;
        L5:
            if (getValue() != 1) goto L7;
            return true;
        }

        public boolean isFalse() {
            if (this.mCondition.getAsBoolean() == true) goto L5;
        L7:
            return false;
        L5:
            if (getValue() != 0) goto L7;
            return true;
        }

        public boolean shouldEnableWithOverrideAndProperty(boolean overrideValue) {
            if (this.mCondition.getAsBoolean() == true) goto L6;
            return false;
        L6:
            if (getValue() != 0) goto L9;
            return false;
        L9:
            if (getValue() == 1) goto L12;
            if (overrideValue == true) goto L12;
            return false;
        L12:
            return true;
        }

        public boolean shouldEnableWithOptInOverrideAndOptOutProperty(boolean overrideValue) {
            if (this.mCondition.getAsBoolean() == true) goto L6;
            return false;
        L6:
            if (getValue() == 0) goto L10;
            if (overrideValue == false) goto L11;
            return true;
        L11:
            return false;
        L10:
            return false;
        }

        public boolean shouldEnableWithOptOutOverrideAndProperty(boolean overrideValue) {
            if (this.mCondition.getAsBoolean() == true) goto L6;
            return false;
        L6:
            if (getValue() == 0) goto L10;
            if (overrideValue == true) goto L11;
            return true;
        L11:
            return false;
        L10:
            return false;
        }

        private int getValue() {
            if (this.mValue != (-1)) goto L17;
            Boolean value = Boolean.valueOf(this.mValueSupplier.get());     // Catch: Exception -> L8
            if (Boolean.TRUE.equals(value) == false) goto L11;
            this.mValue = 1;     // Catch: Exception -> L8
        L18:
        L11:
            if (Boolean.FALSE.equals(value) == false) goto L13;
            this.mValue = 0;     // Catch: Exception -> L8
            goto L18
        L13:
            this.mValue = -2;     // Catch: Exception -> L8
        L15:
            Slog.w(TAG, "Cannot read opt property " + this.mPropertyName);
            this.mValue = -2;
        L17:
            return this.mValue;
        }
    }

    @FunctionalInterface
    private interface ThrowableBooleanSupplier {
        boolean get() throws Exception;
    }

    /* JADX INFO: renamed from: $r8$lambda$2O4xsgobKCcu56KjS-bsyJrHb_k, reason: not valid java name */
    public static /* synthetic */ boolean m10500$r8$lambda$2O4xsgobKCcu56KjSbsyJrHb_k(OptPropFactory r0, String r1) {
        return r0.lambda$create$1(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$A7T62WTf2VHvKQdZKzlFqzIymTM(OptPropFactory r0, String r1) {
        return r0.lambda$create$0(r1);
    }

    public OptPropFactory(PackageManager packageManager, String packageName, int userId) {
        this.mPackageManager = packageManager;
        this.mPackageName = packageName;
        this.mUserId = userId;
    }

    public OptProp create(final String propertyName) {
        return OptProp.m10502$$Nest$smcreate(new OptPropFactory$$ExternalSyntheticLambda0(this, propertyName), propertyName);
    }

    private /* synthetic */ boolean lambda$create$0(String propertyName) throws Exception {
        return this.mPackageManager.getPropertyAsUser(propertyName, this.mPackageName, null, this.mUserId).getBoolean();
    }

    public OptProp create(final String propertyName, BooleanSupplier gateCondition) {
        return OptProp.m10503$$Nest$smcreate(new OptPropFactory$$ExternalSyntheticLambda1(this, propertyName), propertyName, gateCondition);
    }

    private /* synthetic */ boolean lambda$create$1(String propertyName) throws Exception {
        return this.mPackageManager.getPropertyAsUser(propertyName, this.mPackageName, null, this.mUserId).getBoolean();
    }
}
