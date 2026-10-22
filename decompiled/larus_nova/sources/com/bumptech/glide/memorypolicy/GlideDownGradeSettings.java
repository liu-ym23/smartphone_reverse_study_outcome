package com.bumptech.glide.memorypolicy;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings;", "", "<init>", "()V", "TAG", "", "SETTING_KEY", "trimConfigParseResult", "Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$ParseResult;", "getTrimConfigParseResult", "()Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$ParseResult;", "trimConfigParseResult$delegate", "Lkotlin/Lazy;", "defaultConfigFactory", "Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig;", "parseConfigInternal", "resolveLevel", "Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$ResolveResul;", "level", "", "config", "isValidSizeMultiplier", "", "multiplier", "", "isValidTargetRetentionRatio", "targetRetentionRatio", "GlideTrimConfig", "ParseResult", "ResolveResul", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideDownGradeSettings {
    public static final GlideDownGradeSettings INSTANCE = null;
    public static final String SETTING_KEY = "lark_glide_memory_strategy_config";
    public static final String TAG = "GlideTrimPolicy";
    private static final Lazy trimConfigParseResult$delegate = null;

    @AppConfig(key = GlideDownGradeSettings.SETTING_KEY)
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001f B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig;", "", "defaultSizeMultiplier", "", "defaultTargetRetentionRatio", "clamp", "Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig$Clamp;", "rules", "", "Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig$Rule;", "<init>", "(FFLcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig$Clamp;Ljava/util/List;)V", "getDefaultSizeMultiplier", "()F", "getDefaultTargetRetentionRatio", "getClamp", "()Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig$Clamp;", "getRules", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Clamp", "Rule", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GlideTrimConfig {

        @SerializedName("clamp")
        private final Clamp clamp;

        @SerializedName("default_size_multiplier")
        private final float defaultSizeMultiplier;

        @SerializedName("default_target_retention_ratio")
        private final float defaultTargetRetentionRatio;

        @SerializedName("rules")
        private final List<Rule> rules;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig$Clamp;", "", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "<init>", "(FF)V", "getMin", "()F", "getMax", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Clamp {

            @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
            private final float max;

            @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
            private final float min;

            public Clamp() {
                float r100 = 0.0f;
                this(r100, r100, 3, null);
            }

            public static /* synthetic */ Clamp copy$default(Clamp r100, float r101, float r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.min;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.max;
            L9:
                return r100.copy(r101, r102);
            }

            public final float component1() {
                return this.min;
            }

            public final float component2() {
                return this.max;
            }

            public final Clamp copy(float r100, float r101) {
                return new Clamp(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof Clamp) == true) goto L8;
                return false;
            L8:
                Clamp r101 = (Clamp) r100;
                if (Float.compare(this.min, r101.min) == 0) goto L12;
                return false;
            L12:
                if (Float.compare(this.max, r101.max) == 0) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (Float.floatToIntBits(this.min) * 31) + Float.floatToIntBits(this.max);
            }

            public String toString() {
                return "Clamp(min=" + this.min + ", max=" + this.max + ')';
            }

            public final float getMax() {
                return this.max;
            }

            public final float getMin() {
                return this.min;
            }

            public Clamp(float r100, float r101) {
                this.min = r100;
                this.max = r101;
            }

            public /* synthetic */ Clamp(float r100, float r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = 0.1f;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = 1.0f;
            L8:
                this(r100, r101);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig$Rule;", "", "minLevel", "", "targetRetentionRatio", "", "sizeMultiplier", "<init>", "(IFF)V", "getMinLevel", "()I", "getTargetRetentionRatio", "()F", "getSizeMultiplier", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Rule {

            @SerializedName("min_level")
            private final int minLevel;

            @SerializedName("size_multiplier")
            private final float sizeMultiplier;

            @SerializedName("target_retention_ratio")
            private final float targetRetentionRatio;

            public Rule() {
                this(0, 0.0f, 0.0f, 7, null);
            }

            public static /* synthetic */ Rule copy$default(Rule r100, int r101, float r102, float r103, int r104, Object r105) {
                if ((r104 & 1) == 0) goto L6;
                r101 = r100.minLevel;
            L6:
                if ((r104 & 2) == 0) goto L9;
                r102 = r100.targetRetentionRatio;
            L9:
                if ((r104 & 4) == 0) goto L12;
                r103 = r100.sizeMultiplier;
            L12:
                return r100.copy(r101, r102, r103);
            }

            public final int component1() {
                return this.minLevel;
            }

            public final float component2() {
                return this.targetRetentionRatio;
            }

            public final float component3() {
                return this.sizeMultiplier;
            }

            public final Rule copy(int r100, float r101, float r102) {
                return new Rule(r100, r101, r102);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof Rule) == true) goto L8;
                return false;
            L8:
                Rule r101 = (Rule) r100;
                if (this.minLevel == r101.minLevel) goto L12;
                return false;
            L12:
                if (Float.compare(this.targetRetentionRatio, r101.targetRetentionRatio) == 0) goto L15;
                return false;
            L15:
                if (Float.compare(this.sizeMultiplier, r101.sizeMultiplier) == 0) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.minLevel * 31) + Float.floatToIntBits(this.targetRetentionRatio)) * 31) + Float.floatToIntBits(this.sizeMultiplier);
            }

            public String toString() {
                return "Rule(minLevel=" + this.minLevel + ", targetRetentionRatio=" + this.targetRetentionRatio + ", sizeMultiplier=" + this.sizeMultiplier + ')';
            }

            public final int getMinLevel() {
                return this.minLevel;
            }

            public final float getSizeMultiplier() {
                return this.sizeMultiplier;
            }

            public final float getTargetRetentionRatio() {
                return this.targetRetentionRatio;
            }

            public Rule(int r100, float r101, float r102) {
                this.minLevel = r100;
                this.targetRetentionRatio = r101;
                this.sizeMultiplier = r102;
            }

            public /* synthetic */ Rule(int r100, float r101, float r102, int r103, DefaultConstructorMarker r104) {
                if ((r103 & 1) == 0) goto L6;
                r100 = 0;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r101 = 0.0f;
            L9:
                if ((r103 & 4) == 0) goto L11;
                r102 = 1.0f;
            L11:
                this(r100, r101, r102);
            }
        }

        public GlideTrimConfig() {
            this(0.0f, 0.0f, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GlideTrimConfig copy$default(GlideTrimConfig r100, float r101, float r102, Clamp r103, List r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.defaultSizeMultiplier;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.defaultTargetRetentionRatio;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.clamp;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.rules;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final float component1() {
            return this.defaultSizeMultiplier;
        }

        public final float component2() {
            return this.defaultTargetRetentionRatio;
        }

        public final Clamp component3() {
            return this.clamp;
        }

        public final List<Rule> component4() {
            return this.rules;
        }

        public final GlideTrimConfig copy(float r100, float r101, Clamp r102, List<Rule> r103) {
            Intrinsics.checkNotNullParameter(r102, "clamp");
            Intrinsics.checkNotNullParameter(r103, "rules");
            return new GlideTrimConfig(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GlideTrimConfig) == true) goto L8;
            return false;
        L8:
            GlideTrimConfig r101 = (GlideTrimConfig) r100;
            if (Float.compare(this.defaultSizeMultiplier, r101.defaultSizeMultiplier) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.defaultTargetRetentionRatio, r101.defaultTargetRetentionRatio) == 0) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.clamp, r101.clamp) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.rules, r101.rules) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.defaultSizeMultiplier) * 31) + Float.floatToIntBits(this.defaultTargetRetentionRatio)) * 31) + this.clamp.hashCode()) * 31) + this.rules.hashCode();
        }

        public String toString() {
            return "GlideTrimConfig(defaultSizeMultiplier=" + this.defaultSizeMultiplier + ", defaultTargetRetentionRatio=" + this.defaultTargetRetentionRatio + ", clamp=" + this.clamp + ", rules=" + this.rules + ')';
        }

        public final Clamp getClamp() {
            return this.clamp;
        }

        public final float getDefaultSizeMultiplier() {
            return this.defaultSizeMultiplier;
        }

        public final float getDefaultTargetRetentionRatio() {
            return this.defaultTargetRetentionRatio;
        }

        public final List<Rule> getRules() {
            return this.rules;
        }

        public GlideTrimConfig(float r100, float r101, Clamp r102, List<Rule> r103) {
            Intrinsics.checkNotNullParameter(r102, "clamp");
            Intrinsics.checkNotNullParameter(r103, "rules");
            this.defaultSizeMultiplier = r100;
            this.defaultTargetRetentionRatio = r101;
            this.clamp = r102;
            this.rules = r103;
        }

        public /* synthetic */ GlideTrimConfig(float r100, float r101, Clamp r102, List r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L5;
            r100 = 1.0f;
        L5:
            float r106 = 0.0f;
            if ((r104 & 2) == 0) goto L9;
            r101 = 0.0f;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = new Clamp(r106, r106, 3, null);
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = CollectionsKt.emptyList();
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$ParseResult;", "", "config", "Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig;", "failed", "", "error", "", "<init>", "(Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig;ZLjava/lang/String;)V", "getConfig", "()Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$GlideTrimConfig;", "getFailed", "()Z", "getError", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ParseResult {
        private final GlideTrimConfig config;
        private final String error;
        private final boolean failed;

        public static /* synthetic */ ParseResult copy$default(ParseResult r100, GlideTrimConfig r101, boolean r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.config;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.failed;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.error;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final GlideTrimConfig component1() {
            return this.config;
        }

        public final boolean component2() {
            return this.failed;
        }

        public final String component3() {
            return this.error;
        }

        public final ParseResult copy(GlideTrimConfig r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "config");
            return new ParseResult(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ParseResult) == true) goto L8;
            return false;
        L8:
            ParseResult r101 = (ParseResult) r100;
            if (Intrinsics.areEqual(this.config, r101.config) == true) goto L12;
            return false;
        L12:
            if (this.failed == r101.failed) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.error, r101.error) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = this.config.hashCode() * 31;
            if (this.failed == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            String r103 = this.error;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public String toString() {
            return "ParseResult(config=" + this.config + ", failed=" + this.failed + ", error=" + this.error + ')';
        }

        public final GlideTrimConfig getConfig() {
            return this.config;
        }

        public final String getError() {
            return this.error;
        }

        public final boolean getFailed() {
            return this.failed;
        }

        public ParseResult(GlideTrimConfig r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.config = r100;
            this.failed = r101;
            this.error = r102;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bumptech/glide/memorypolicy/GlideDownGradeSettings$ResolveResul;", "", "rangeText", "", "targetRetentionRatio", "", "sizeMultiplier", "<init>", "(Ljava/lang/String;FF)V", "getRangeText", "()Ljava/lang/String;", "getTargetRetentionRatio", "()F", "getSizeMultiplier", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResolveResul {
        private final String rangeText;
        private final float sizeMultiplier;
        private final float targetRetentionRatio;

        public static /* synthetic */ ResolveResul copy$default(ResolveResul r100, String r101, float r102, float r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.rangeText;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.targetRetentionRatio;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.sizeMultiplier;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.rangeText;
        }

        public final float component2() {
            return this.targetRetentionRatio;
        }

        public final float component3() {
            return this.sizeMultiplier;
        }

        public final ResolveResul copy(String r100, float r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "rangeText");
            return new ResolveResul(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ResolveResul) == true) goto L8;
            return false;
        L8:
            ResolveResul r101 = (ResolveResul) r100;
            if (Intrinsics.areEqual(this.rangeText, r101.rangeText) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.targetRetentionRatio, r101.targetRetentionRatio) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.sizeMultiplier, r101.sizeMultiplier) == 0) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.rangeText.hashCode() * 31) + Float.floatToIntBits(this.targetRetentionRatio)) * 31) + Float.floatToIntBits(this.sizeMultiplier);
        }

        public String toString() {
            return "ResolveResul(rangeText=" + this.rangeText + ", targetRetentionRatio=" + this.targetRetentionRatio + ", sizeMultiplier=" + this.sizeMultiplier + ')';
        }

        public final String getRangeText() {
            return this.rangeText;
        }

        public final float getSizeMultiplier() {
            return this.sizeMultiplier;
        }

        public final float getTargetRetentionRatio() {
            return this.targetRetentionRatio;
        }

        public ResolveResul(String r100, float r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "rangeText");
            this.rangeText = r100;
            this.targetRetentionRatio = r101;
            this.sizeMultiplier = r102;
        }
    }

    private GlideDownGradeSettings() {
    }

    private final boolean isValidTargetRetentionRatio(float r100) {
        if (0.0f <= r100) goto L5;
        return false;
    L5:
        if (r100 > 1.0f) goto L9;
        return true;
    L9:
        return false;
    }

    static {
        INSTANCE = new GlideDownGradeSettings();
        trimConfigParseResult$delegate = LazyKt.lazy(GlideDownGradeSettings$trimConfigParseResult$2.INSTANCE);
    }

    private final GlideTrimConfig defaultConfigFactory() {
        return new GlideTrimConfig(0.0f, 0.0f, null, null, 15, null);
    }

    public final ParseResult getTrimConfigParseResult() {
        return (ParseResult) trimConfigParseResult$delegate.getValue();
    }

    private final ParseResult parseConfigInternal() {
        GlideTrimConfig r100 = defaultConfigFactory();
        GlideTrimConfig r101 = (GlideTrimConfig) SettingManager.getInstance().get(GlideTrimConfig.class);
        if (r101 != null) goto L7;
        return new ParseResult(r100, true, "config is null");
    L7:
        if (r101.getRules().isEmpty() == false) goto L11;
        return new ParseResult(r100, true, "rules_empty");
    L11:
        if (r101.getClamp().getMin() <= r101.getClamp().getMax()) goto L15;
        return new ParseResult(r100, true, "clamp_invalid:min_gt_max: " + r101.getClamp().getMin() + " > " + r101.getClamp().getMax());
    L15:
        if (isValidSizeMultiplier(r101.getDefaultSizeMultiplier()) == true) goto L19;
        return new ParseResult(r100, true, "default_multiplier_illegal:" + r101.getDefaultSizeMultiplier());
    L19:
        if (isValidTargetRetentionRatio(r101.getDefaultTargetRetentionRatio()) == false) goto L21;
        LinkedHashSet r102 = new LinkedHashSet();
        Iterator<GlideTrimConfig.Rule> r103 = r101.getRules().iterator();
    L24:
        if (r103.hasNext() == false) goto L38;
        GlideTrimConfig.Rule r104 = r103.next();
        if (isValidSizeMultiplier(r104.getSizeMultiplier()) == false) goto L28;
        if (isValidTargetRetentionRatio(r104.getTargetRetentionRatio()) == false) goto L32;
        if (r102.add(Integer.valueOf(r104.getMinLevel())) == true) goto L24;
        return new ParseResult(r100, true, "rule_invalid:min_level_duplicate:" + r104.getMinLevel());
    L32:
        return new ParseResult(r100, true, "rule_invalid:target_retention_ratio_illegal:" + r104.getTargetRetentionRatio());
    L28:
        return new ParseResult(r100, true, "rule_invalid:multiplier_illegal:" + r104.getSizeMultiplier());
    L38:
        return new ParseResult(GlideTrimConfig.copy$default(r101, 0.0f, 0.0f, null, CollectionsKt.sortedWith(r101.getRules(), new GlideDownGradeSettings$parseConfigInternal$$inlined$sortedByDescending$1()), 7, null), false, null);
    L21:
        return new ParseResult(r100, true, "default_target_retention_ratio_illegal:" + r101.getDefaultTargetRetentionRatio());
    }

    public static final /* synthetic */ ParseResult access$parseConfigInternal(GlideDownGradeSettings r100) {
        return r100.parseConfigInternal();
    }

    private final boolean isValidSizeMultiplier(float r100) {
        if (Float.isInfinite(r100) == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
    L12:
        return false;
    L10:
        if (r100 <= 0.0f) goto L12;
        return true;
    L5:
        if (Float.isNaN(r100) == true) goto L7;
        r101 = true;
        goto L8
    }

    @JvmStatic
    public static final ResolveResul resolveLevel(int r100, GlideTrimConfig r101) {
        Intrinsics.checkNotNullParameter(r101, "config");
        List<GlideTrimConfig.Rule> r102 = r101.getRules();
        if (r102.isEmpty() == true) goto L5;
        String r103 = "<" + ((GlideTrimConfig.Rule) ListProtector.get(r102, r102.size() - 1)).getMinLevel();
        float r104 = r101.getDefaultTargetRetentionRatio();
        float r105 = r101.getDefaultSizeMultiplier();
        int r106 = r102.size();
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L16;
        GlideTrimConfig.Rule r108 = (GlideTrimConfig.Rule) ListProtector.get(r102, r107);
        if (r100 >= r108.getMinLevel()) goto L10;
        r107 = r107 + 1;
        goto L7
    L10:
        r105 = r108.getSizeMultiplier();
        r104 = r108.getTargetRetentionRatio();
        if (r107 <= 0) goto L13;
        String r109 = "[" + r108.getMinLevel() + ", " + ((GlideTrimConfig.Rule) ListProtector.get(r102, r107 - 1)).getMinLevel() + ')';
    L14:
        r103 = r109;
        goto L16
    L13:
        r109 = "[" + r108.getMinLevel() + ", +∞)";
    L16:
        GlideTrimConfig.Clamp r110 = r101.getClamp();
        return new ResolveResul(r103, Math.max(Math.min(r104, 1.0f), 0.0f), (float) Math.max(Math.min(r105, r110.getMax()), r110.getMin()));
    L5:
        return new ResolveResul("<", r101.getDefaultTargetRetentionRatio(), r101.getDefaultSizeMultiplier());
    }
}
