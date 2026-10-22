package com.obric.common.oea.foundation.animation.command;

import androidx.exifinterface.media.ExifInterface;
import com.obric.common.oea.foundation.animation.AnimationInfo;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: AnimationCommand.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "initialValue", "getInitialValue", "()Ljava/lang/Object;", "property", "", "getProperty", "()Ljava/lang/String;", "targetValue", "getTargetValue", "valueClass", "Lkotlin/reflect/KClass;", "getValueClass", "()Lkotlin/reflect/KClass;", "convertToAnimatedPropertyInfo", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "SpringAnimationCommand", "TweenAnimationCommand", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$TweenAnimationCommand;", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$SpringAnimationCommand;", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AnimationCommand<T> {

    /* JADX INFO: compiled from: AnimationCommand.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BC\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000e\u0010\u001d\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001e\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\tHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u000bHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#H\u0016J^\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00028\u00012\b\b\u0002\u0010\u0007\u001a\u00028\u00012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$SpringAnimationCommand;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "property", "", "initialValue", "targetValue", "valueClass", "Lkotlin/reflect/KClass;", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "initialVelocity", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/reflect/KClass;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)V", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getInitialVelocity", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getProperty", "()Ljava/lang/String;", "getSpec", "()Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "getTargetValue", "getValueClass", "()Lkotlin/reflect/KClass;", "component1", "component2", "component3", "component4", "component5", "component6", "convertToAnimatedPropertyInfo", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/reflect/KClass;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$SpringAnimationCommand;", "equals", "", "other", "hashCode", "", "toString", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SpringAnimationCommand<T> extends AnimationCommand<T> {
        private final T initialValue;
        private final Float initialVelocity;
        private final String property;
        private final AnimationSpec<T> spec;
        private final T targetValue;
        private final KClass<T> valueClass;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SpringAnimationCommand copy$default(SpringAnimationCommand r4, String r5, Object r6, Object r7, KClass r8, AnimationSpec r9, Float r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.getProperty();
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.getInitialValue();
        L8:
            Object r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.getTargetValue();
        L11:
            Object r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.getValueClass();
        L14:
            KClass r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.spec;
        L17:
            AnimationSpec r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.initialVelocity;
        L20:
            String r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final String component1() {
            return getProperty();
        }

        public final T component2() {
            return getInitialValue();
        }

        public final T component3() {
            return getTargetValue();
        }

        public final KClass<T> component4() {
            return getValueClass();
        }

        public final AnimationSpec<T> component5() {
            return this.spec;
        }

        public final Float component6() {
            return this.initialVelocity;
        }

        public final SpringAnimationCommand<T> copy(String r8, T r9, T r10, KClass<T> r11, AnimationSpec<T> r12, Float r13) {
            Intrinsics.checkNotNullParameter(r8, "property");
            Intrinsics.checkNotNullParameter(r9, "initialValue");
            Intrinsics.checkNotNullParameter(r10, "targetValue");
            Intrinsics.checkNotNullParameter(r11, "valueClass");
            Intrinsics.checkNotNullParameter(r12, "spec");
            return new SpringAnimationCommand(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof SpringAnimationCommand) == false) goto L18;
            SpringAnimationCommand r4 = (SpringAnimationCommand) r3;
            if (Intrinsics.areEqual(getProperty(), r4.getProperty()) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(getInitialValue(), r4.getInitialValue()) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(getTargetValue(), r4.getTargetValue()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(getValueClass(), r4.getValueClass()) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.spec, r4.spec) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.initialVelocity, r4.initialVelocity) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            String r0 = getProperty();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            T r4 = getInitialValue();
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = getTargetValue();
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            KClass<T> r10 = getValueClass();
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            AnimationSpec<T> r13 = this.spec;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.initialVelocity;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "SpringAnimationCommand(property=" + getProperty() + ", initialValue=" + getInitialValue() + ", targetValue=" + getTargetValue() + ", valueClass=" + getValueClass() + ", spec=" + this.spec + ", initialVelocity=" + this.initialVelocity + ")";
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public String getProperty() {
            return this.property;
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public T getInitialValue() {
            return this.initialValue;
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public T getTargetValue() {
            return this.targetValue;
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public KClass<T> getValueClass() {
            return this.valueClass;
        }

        public final AnimationSpec<T> getSpec() {
            return this.spec;
        }

        public final Float getInitialVelocity() {
            return this.initialVelocity;
        }

        public SpringAnimationCommand(String r2, T r3, T r4, KClass<T> r5, AnimationSpec<T> r6, Float r7) {
            Intrinsics.checkNotNullParameter(r2, "property");
            Intrinsics.checkNotNullParameter(r3, "initialValue");
            Intrinsics.checkNotNullParameter(r4, "targetValue");
            Intrinsics.checkNotNullParameter(r5, "valueClass");
            Intrinsics.checkNotNullParameter(r6, "spec");
            super(null);
            this.property = r2;
            this.initialValue = r3;
            this.targetValue = r4;
            this.valueClass = r5;
            this.spec = r6;
            this.initialVelocity = r7;
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public AnimationInfo<T> convertToAnimatedPropertyInfo() {
            return new AnimationInfo(getProperty(), getInitialValue(), getTargetValue(), this.spec, this.initialVelocity, getValueClass(), 0.0f, 64, null);
        }
    }

    /* JADX INFO: compiled from: AnimationCommand.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BC\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000e\u0010\u001d\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001e\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\tHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u000bHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#H\u0016J^\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00028\u00012\b\b\u0002\u0010\u0007\u001a\u00028\u00012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$TweenAnimationCommand;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "property", "", "initialValue", "targetValue", "valueClass", "Lkotlin/reflect/KClass;", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "initialVelocity", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/reflect/KClass;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)V", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getInitialVelocity", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getProperty", "()Ljava/lang/String;", "getSpec", "()Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "getTargetValue", "getValueClass", "()Lkotlin/reflect/KClass;", "component1", "component2", "component3", "component4", "component5", "component6", "convertToAnimatedPropertyInfo", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/reflect/KClass;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/command/AnimationCommand$TweenAnimationCommand;", "equals", "", "other", "hashCode", "", "toString", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TweenAnimationCommand<T> extends AnimationCommand<T> {
        private final T initialValue;
        private final Float initialVelocity;
        private final String property;
        private final AnimationSpec<T> spec;
        private final T targetValue;
        private final KClass<T> valueClass;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TweenAnimationCommand copy$default(TweenAnimationCommand r4, String r5, Object r6, Object r7, KClass r8, AnimationSpec r9, Float r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.getProperty();
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.getInitialValue();
        L8:
            Object r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.getTargetValue();
        L11:
            Object r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.getValueClass();
        L14:
            KClass r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.spec;
        L17:
            AnimationSpec r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.initialVelocity;
        L20:
            String r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final String component1() {
            return getProperty();
        }

        public final T component2() {
            return getInitialValue();
        }

        public final T component3() {
            return getTargetValue();
        }

        public final KClass<T> component4() {
            return getValueClass();
        }

        public final AnimationSpec<T> component5() {
            return this.spec;
        }

        public final Float component6() {
            return this.initialVelocity;
        }

        public final TweenAnimationCommand<T> copy(String r8, T r9, T r10, KClass<T> r11, AnimationSpec<T> r12, Float r13) {
            Intrinsics.checkNotNullParameter(r8, "property");
            Intrinsics.checkNotNullParameter(r9, "initialValue");
            Intrinsics.checkNotNullParameter(r10, "targetValue");
            Intrinsics.checkNotNullParameter(r11, "valueClass");
            Intrinsics.checkNotNullParameter(r12, "spec");
            return new TweenAnimationCommand(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof TweenAnimationCommand) == false) goto L18;
            TweenAnimationCommand r4 = (TweenAnimationCommand) r3;
            if (Intrinsics.areEqual(getProperty(), r4.getProperty()) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(getInitialValue(), r4.getInitialValue()) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(getTargetValue(), r4.getTargetValue()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(getValueClass(), r4.getValueClass()) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.spec, r4.spec) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.initialVelocity, r4.initialVelocity) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            String r0 = getProperty();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            T r4 = getInitialValue();
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = getTargetValue();
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            KClass<T> r10 = getValueClass();
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            AnimationSpec<T> r13 = this.spec;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.initialVelocity;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "TweenAnimationCommand(property=" + getProperty() + ", initialValue=" + getInitialValue() + ", targetValue=" + getTargetValue() + ", valueClass=" + getValueClass() + ", spec=" + this.spec + ", initialVelocity=" + this.initialVelocity + ")";
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public String getProperty() {
            return this.property;
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public T getInitialValue() {
            return this.initialValue;
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public T getTargetValue() {
            return this.targetValue;
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public KClass<T> getValueClass() {
            return this.valueClass;
        }

        public final AnimationSpec<T> getSpec() {
            return this.spec;
        }

        public final Float getInitialVelocity() {
            return this.initialVelocity;
        }

        public TweenAnimationCommand(String r2, T r3, T r4, KClass<T> r5, AnimationSpec<T> r6, Float r7) {
            Intrinsics.checkNotNullParameter(r2, "property");
            Intrinsics.checkNotNullParameter(r3, "initialValue");
            Intrinsics.checkNotNullParameter(r4, "targetValue");
            Intrinsics.checkNotNullParameter(r5, "valueClass");
            Intrinsics.checkNotNullParameter(r6, "spec");
            super(null);
            this.property = r2;
            this.initialValue = r3;
            this.targetValue = r4;
            this.valueClass = r5;
            this.spec = r6;
            this.initialVelocity = r7;
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public AnimationInfo<T> convertToAnimatedPropertyInfo() {
            return new AnimationInfo(getProperty(), getInitialValue(), getTargetValue(), this.spec, this.initialVelocity, getValueClass(), 0.0f, 64, null);
        }
    }

    public abstract AnimationInfo<T> convertToAnimatedPropertyInfo();

    public abstract T getInitialValue();

    public abstract String getProperty();

    public abstract T getTargetValue();

    public abstract KClass<T> getValueClass();

    private AnimationCommand() {
    }

    public /* synthetic */ AnimationCommand(DefaultConstructorMarker r1) {
        this();
    }
}
