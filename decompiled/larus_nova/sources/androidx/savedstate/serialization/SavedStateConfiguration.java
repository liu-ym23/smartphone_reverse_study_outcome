package androidx.savedstate.serialization;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.modules.d;
import kotlinx.serialization.modules.e;
import kotlinx.serialization.modules.h;
import kotlinx.serialization.modules.i;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B'\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/savedstate/serialization/SavedStateConfiguration;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "classDiscriminatorMode", "", "encodeDefaults", "", "<init>", "(Lkotlinx/serialization/modules/SerializersModule;IZ)V", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getClassDiscriminatorMode", "()I", "getEncodeDefaults", "()Z", "Builder", "Companion", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateConfiguration {
    public static final Companion Companion = null;
    public static final SavedStateConfiguration DEFAULT = null;
    private final int classDiscriminatorMode;
    private final boolean encodeDefaults;
    private final d serializersModule;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u001b\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u001cR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Landroidx/savedstate/serialization/SavedStateConfiguration$Builder;", "", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "setSerializersModule", "(Lkotlinx/serialization/modules/SerializersModule;)V", "encodeDefaults", "", "getEncodeDefaults$annotations", "()V", "getEncodeDefaults", "()Z", "setEncodeDefaults", "(Z)V", "classDiscriminatorMode", "", "getClassDiscriminatorMode$annotations", "getClassDiscriminatorMode", "()I", "setClassDiscriminatorMode", "(I)V", "build", "build$savedstate", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private int classDiscriminatorMode;
        private boolean encodeDefaults;
        private d serializersModule;

        public static /* synthetic */ void getClassDiscriminatorMode$annotations() {
        }

        public static /* synthetic */ void getEncodeDefaults$annotations() {
        }

        public final SavedStateConfiguration build$savedstate() {
            d r100 = SavedStateConfigurationKt.access$getDEFAULT_SERIALIZERS_MODULE$p();
            d r101 = this.serializersModule;
            kotlinx.serialization.modules.c r102 = i.f505488a;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "other");
            e r103 = new e();
            Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
            r100.a(r103);
            r101.a(new h(r103));
            return new SavedStateConfiguration(r103.f(), this.classDiscriminatorMode, this.encodeDefaults, null);
        }

        public final int getClassDiscriminatorMode() {
            return this.classDiscriminatorMode;
        }

        public final boolean getEncodeDefaults() {
            return this.encodeDefaults;
        }

        public final d getSerializersModule() {
            return this.serializersModule;
        }

        public Builder(SavedStateConfiguration r100) {
            Intrinsics.checkNotNullParameter(r100, "configuration");
            this.serializersModule = r100.getSerializersModule();
            this.encodeDefaults = r100.getEncodeDefaults();
            this.classDiscriminatorMode = r100.getClassDiscriminatorMode();
        }

        public final void setClassDiscriminatorMode(int r100) {
            this.classDiscriminatorMode = r100;
        }

        public final void setEncodeDefaults(boolean r100) {
            this.encodeDefaults = r100;
        }

        public final void setSerializersModule(d r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.serializersModule = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/savedstate/serialization/SavedStateConfiguration$Companion;", "", "<init>", "()V", "DEFAULT", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public /* synthetic */ SavedStateConfiguration(d r100, int r101, boolean r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new SavedStateConfiguration(null, 0, false, 7, null);
    }

    public final int getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final d getSerializersModule() {
        return this.serializersModule;
    }

    private SavedStateConfiguration(d r100, int r101, boolean r102) {
        this.serializersModule = r100;
        this.classDiscriminatorMode = r101;
        this.encodeDefaults = r102;
    }

    public /* synthetic */ SavedStateConfiguration(d r100, int r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = SavedStateConfigurationKt.access$getDEFAULT_SERIALIZERS_MODULE$p();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 2;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
