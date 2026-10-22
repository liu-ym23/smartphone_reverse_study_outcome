package com.obric.capabilitykit.version;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.obric.capabilitykit.entity.app.EntityType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.collections.n;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/version/PersonalContextData;", "", "supportEntityTypes", "", "", "(Ljava/util/Set;)V", "getSupportEntityTypes", "()Ljava/util/Set;", "fillBundle", "", "bundle", "Landroid/os/Bundle;", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PersonalContextData {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String SUPPORT_ENTITY_TYPE_KEY = "support_entity_type";

    @NotNull
    private final Set<Integer> supportEntityTypes;

    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/version/PersonalContextData$Companion;", "", "()V", "SUPPORT_ENTITY_TYPE_KEY", "", "createFromBundle", "Lcom/obric/capabilitykit/version/PersonalContextData;", "bundle", "Landroid/os/Bundle;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final PersonalContextData createFromBundle(@NotNull Bundle r10) {
            q.g(r10, "bundle");
            int[] r11 = r10.getIntArray(PersonalContextData.SUPPORT_ENTITY_TYPE_KEY);
            if (r11 == null) goto L6;
            Set<Integer> r12 = n.N(r11);
            if (r12 == null) goto L6;
        L8:
            return new PersonalContextData(r12);
        L6:
            r12 = EntityType.INSTANCE.getClassMap().keySet();
            goto L8
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PersonalContextData(@NotNull Set<Integer> r10) {
        q.g(r10, "supportEntityTypes");
        this.supportEntityTypes = r10;
    }

    public final void fillBundle(@NotNull Bundle r10) {
        q.g(r10, "bundle");
        r10.putIntArray(SUPPORT_ENTITY_TYPE_KEY, b0.w0(this.supportEntityTypes));
    }

    @NotNull
    public final Set<Integer> getSupportEntityTypes() {
        return this.supportEntityTypes;
    }
}
