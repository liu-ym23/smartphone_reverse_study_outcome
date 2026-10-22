package android.view.serialization;

import E9.d;
import E9.e;
import E9.g;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.modules.a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u00132\u00020\u0001:\u0002\u0014\u0013B'\b\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/savedstate/serialization/SavedStateConfiguration;", "", "LE9/e;", "serializersModule", "", "classDiscriminatorMode", "", "encodeDefaults", AppAgent.CONSTRUCT, "(LE9/e;IZ)V", "LE9/e;", "getSerializersModule", "()LE9/e;", "I", "getClassDiscriminatorMode", "()I", "Z", "getEncodeDefaults", "()Z", "Companion", "Builder", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateConfiguration {
    public static final SavedStateConfiguration DEFAULT = new SavedStateConfiguration(null, 0, false, 7, null);
    private final int classDiscriminatorMode;
    private final boolean encodeDefaults;
    private final e serializersModule;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b \u0010\u0018\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/savedstate/serialization/SavedStateConfiguration$Builder;", "", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "configuration", AppAgent.CONSTRUCT, "(Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "build$savedstate_release", "()Landroidx/savedstate/serialization/SavedStateConfiguration;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "LE9/e;", "serializersModule", "LE9/e;", "getSerializersModule", "()LE9/e;", "setSerializersModule", "(LE9/e;)V", "", "encodeDefaults", "Z", "getEncodeDefaults", "()Z", "setEncodeDefaults", "(Z)V", "getEncodeDefaults$annotations", "()V", "", "classDiscriminatorMode", "I", "getClassDiscriminatorMode", "()I", "setClassDiscriminatorMode", "(I)V", "getClassDiscriminatorMode$annotations", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private int classDiscriminatorMode;
        private boolean encodeDefaults;
        private e serializersModule;

        public Builder(SavedStateConfiguration configuration) {
            k.f(configuration, "configuration");
            this.serializersModule = configuration.getSerializersModule();
            this.encodeDefaults = configuration.getEncodeDefaults();
            this.classDiscriminatorMode = configuration.getClassDiscriminatorMode();
        }

        public static /* synthetic */ void getClassDiscriminatorMode$annotations() {
        }

        public static /* synthetic */ void getEncodeDefaults$annotations() {
        }

        public final SavedStateConfiguration build$savedstate_release() {
            e eVar = SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE;
            e other = this.serializersModule;
            d dVar = g.f499a;
            k.f(eVar, "<this>");
            k.f(other, "other");
            a aVar = new a();
            eVar.a(aVar);
            other.a(new A8.d(aVar, 1));
            return new SavedStateConfiguration(aVar.c(), this.classDiscriminatorMode, this.encodeDefaults, null);
        }

        public final int getClassDiscriminatorMode() {
            return this.classDiscriminatorMode;
        }

        public final boolean getEncodeDefaults() {
            return this.encodeDefaults;
        }

        public final e getSerializersModule() {
            return this.serializersModule;
        }

        public final void setClassDiscriminatorMode(int i) {
            this.classDiscriminatorMode = i;
        }

        public final void setEncodeDefaults(boolean z10) {
            this.encodeDefaults = z10;
        }

        public final void setSerializersModule(e eVar) {
            k.f(eVar, "<set-?>");
            this.serializersModule = eVar;
        }
    }

    public /* synthetic */ SavedStateConfiguration(e eVar, int i, boolean z10, kotlin.jvm.internal.e eVar2) {
        this(eVar, i, z10);
    }

    public final int getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final e getSerializersModule() {
        return this.serializersModule;
    }

    private SavedStateConfiguration(e eVar, int i, boolean z10) {
        this.serializersModule = eVar;
        this.classDiscriminatorMode = i;
        this.encodeDefaults = z10;
    }

    public /* synthetic */ SavedStateConfiguration(e eVar, int i, boolean z10, int i6, kotlin.jvm.internal.e eVar2) {
        this((i6 & 1) != 0 ? SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE : eVar, (i6 & 2) != 0 ? 2 : i, (i6 & 4) != 0 ? false : z10);
    }
}
