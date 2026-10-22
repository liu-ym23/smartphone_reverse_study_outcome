package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Locale;

/* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface SkillSecurityDecisionAction extends Parcelable {
    public static final a Companion = null;

    /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
    public static final class Allow implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<Allow> CREATOR = null;
        public static final Allow INSTANCE = null;
        private static final boolean allowsSkillUse = false;
        private static final String rawValue = null;

        /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
        public static final class Creator implements Parcelable.Creator<Allow> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Allow createFromParcel(Parcel r1) {
                o.e(r1, "parcel");
                r1.readInt();
                return Allow.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Allow createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Allow[] newArray(int r1) {
                return new Allow[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Allow[] newArray(int r1) {
                return newArray(r1);
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, Allow.class) == true) goto L9;
            return false;
        L9:
            Allow r2 = (Allow) ZeusTransformUtils.preCheckCast(r3, Allow.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 476038720;
        }

        public String toString() {
            return "Allow";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            o.e(r1, "dest");
            r1.writeInt(1);
        }

        private Allow() {
        }

        static {
            INSTANCE = new Allow();
            rawValue = "allow";
            allowsSkillUse = true;
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return rawValue;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return allowsSkillUse;
        }
    }

    /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
    public static final class Block implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<Block> CREATOR = null;
        public static final Block INSTANCE = null;
        private static final boolean allowsSkillUse = false;
        private static final String rawValue = null;

        /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
        public static final class Creator implements Parcelable.Creator<Block> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Block createFromParcel(Parcel r1) {
                o.e(r1, "parcel");
                r1.readInt();
                return Block.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Block createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Block[] newArray(int r1) {
                return new Block[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Block[] newArray(int r1) {
                return newArray(r1);
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, Block.class) == true) goto L9;
            return false;
        L9:
            Block r2 = (Block) ZeusTransformUtils.preCheckCast(r3, Block.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 476964740;
        }

        public String toString() {
            return "Block";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            o.e(r1, "dest");
            r1.writeInt(1);
        }

        private Block() {
        }

        static {
            INSTANCE = new Block();
            rawValue = "block";
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return rawValue;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return allowsSkillUse;
        }
    }

    /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
    public static final class CallUser implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<CallUser> CREATOR = null;
        public static final CallUser INSTANCE = null;
        private static final boolean allowsSkillUse = false;
        private static final String rawValue = null;

        /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
        public static final class Creator implements Parcelable.Creator<CallUser> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CallUser createFromParcel(Parcel r1) {
                o.e(r1, "parcel");
                r1.readInt();
                return CallUser.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ CallUser createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CallUser[] newArray(int r1) {
                return new CallUser[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ CallUser[] newArray(int r1) {
                return newArray(r1);
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, CallUser.class) == true) goto L9;
            return false;
        L9:
            CallUser r2 = (CallUser) ZeusTransformUtils.preCheckCast(r3, CallUser.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1996841202;
        }

        public String toString() {
            return "CallUser";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            o.e(r1, "dest");
            r1.writeInt(1);
        }

        private CallUser() {
        }

        static {
            INSTANCE = new CallUser();
            rawValue = "call_user";
            allowsSkillUse = true;
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return rawValue;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return allowsSkillUse;
        }
    }

    /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
    public static final class Clarify implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<Clarify> CREATOR = null;
        public static final Clarify INSTANCE = null;
        private static final boolean allowsSkillUse = false;
        private static final String rawValue = null;

        /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
        public static final class Creator implements Parcelable.Creator<Clarify> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Clarify createFromParcel(Parcel r1) {
                o.e(r1, "parcel");
                r1.readInt();
                return Clarify.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Clarify createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Clarify[] newArray(int r1) {
                return new Clarify[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Clarify[] newArray(int r1) {
                return newArray(r1);
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, Clarify.class) == true) goto L9;
            return false;
        L9:
            Clarify r2 = (Clarify) ZeusTransformUtils.preCheckCast(r3, Clarify.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -323362919;
        }

        public String toString() {
            return "Clarify";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            o.e(r1, "dest");
            r1.writeInt(1);
        }

        private Clarify() {
        }

        static {
            INSTANCE = new Clarify();
            rawValue = "clarify";
            allowsSkillUse = true;
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return rawValue;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return allowsSkillUse;
        }
    }

    /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
    public static final class Notice implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<Notice> CREATOR = null;
        public static final Notice INSTANCE = null;
        private static final boolean allowsSkillUse = false;
        private static final String rawValue = null;

        /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
        public static final class Creator implements Parcelable.Creator<Notice> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Notice createFromParcel(Parcel r1) {
                o.e(r1, "parcel");
                r1.readInt();
                return Notice.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Notice createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Notice[] newArray(int r1) {
                return new Notice[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Notice[] newArray(int r1) {
                return newArray(r1);
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, Notice.class) == true) goto L9;
            return false;
        L9:
            Notice r2 = (Notice) ZeusTransformUtils.preCheckCast(r3, Notice.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -2047487295;
        }

        public String toString() {
            return "Notice";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            o.e(r1, "dest");
            r1.writeInt(1);
        }

        private Notice() {
        }

        static {
            INSTANCE = new Notice();
            rawValue = "notice";
            allowsSkillUse = true;
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return rawValue;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return allowsSkillUse;
        }
    }

    /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
    public static final class Unknown implements SkillSecurityDecisionAction {
        public static final Parcelable.Creator<Unknown> CREATOR = null;
        private final boolean allowsSkillUse;
        private final String rawValue;

        /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
        public static final class Creator implements Parcelable.Creator<Unknown> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unknown createFromParcel(Parcel r1) {
                o.e(r1, "parcel");
                return new Unknown(r1.readString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Unknown createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unknown[] newArray(int r1) {
                return new Unknown[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Unknown[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ Unknown copy$default(Unknown r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.rawValue;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.rawValue;
        }

        public final Unknown copy(String r1) {
            o.e(r1, "rawValue");
            return new Unknown(r1);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Unknown.class) == true) goto L8;
            return false;
        L8:
            Unknown r6 = (Unknown) ZeusTransformUtils.preCheckCast(r5, Unknown.class, "com.obric.aiagent.plugin");
            if (o.a(this.rawValue, r6.rawValue) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.rawValue.hashCode();
        }

        public String toString() {
            return "Unknown(rawValue=" + this.rawValue + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            o.e(r1, "dest");
            r1.writeString(this.rawValue);
        }

        public Unknown(String r2) {
            o.e(r2, "rawValue");
            this.rawValue = r2;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public String getRawValue() {
            return this.rawValue;
        }

        @Override // com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction
        public boolean getAllowsSkillUse() {
            return this.allowsSkillUse;
        }
    }

    /* JADX INFO: compiled from: SkillSecurityDecisionAction.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f16262a = null;

        static {
            f16262a = new a();
        }

        private a() {
        }

        public final SkillSecurityDecisionAction a(String r4) {
            if (r4 != null) goto L5;
            return null;
        L5:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
            r4 = null;
        L8:
            if (r4 == null) goto L36;
            String r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            Locale r0 = Locale.ROOT;
            o.c(r0, "ROOT");
            String r5 = r3.toLowerCase(r0);
            o.c(r5, "toLowerCase(...)");
            if (o.a(r5, Allow.INSTANCE.getRawValue()) == false) goto L14;
            return (SkillSecurityDecisionAction) ZeusTransformUtils.preCheckCast(Allow.INSTANCE, SkillSecurityDecisionAction.class, "com.obric.aiagent.plugin");
        L14:
            if (o.a(r5, Notice.INSTANCE.getRawValue()) == false) goto L17;
            return (SkillSecurityDecisionAction) ZeusTransformUtils.preCheckCast(Notice.INSTANCE, SkillSecurityDecisionAction.class, "com.obric.aiagent.plugin");
        L17:
            if (o.a(r5, CallUser.INSTANCE.getRawValue()) == true) goto L29;
            if (o.a(r5, "calluser") == true) goto L29;
            if (o.a(r5, Clarify.INSTANCE.getRawValue()) == false) goto L25;
            return (SkillSecurityDecisionAction) ZeusTransformUtils.preCheckCast(Clarify.INSTANCE, SkillSecurityDecisionAction.class, "com.obric.aiagent.plugin");
        L25:
            if (o.a(r5, Block.INSTANCE.getRawValue()) == false) goto L35;
            return (SkillSecurityDecisionAction) ZeusTransformUtils.preCheckCast(Block.INSTANCE, SkillSecurityDecisionAction.class, "com.obric.aiagent.plugin");
        L35:
            return (SkillSecurityDecisionAction) ZeusTransformUtils.preCheckCast(new Unknown(r4), SkillSecurityDecisionAction.class, "com.obric.aiagent.plugin");
        L29:
            return (SkillSecurityDecisionAction) ZeusTransformUtils.preCheckCast(CallUser.INSTANCE, SkillSecurityDecisionAction.class, "com.obric.aiagent.plugin");
        L36:
            return null;
        }
    }

    static {
        Companion = a.f16262a;
    }

    boolean getAllowsSkillUse();

    String getRawValue();
}
