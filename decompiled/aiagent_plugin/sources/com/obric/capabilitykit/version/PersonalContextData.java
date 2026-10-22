package com.obric.capabilitykit.version;

import android.os.Bundle;
import com.obric.capabilitykit.entity.app.EntityType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class PersonalContextData {
    public static final Companion Companion = null;
    private static final String SUPPORT_ENTITY_TYPE_KEY = "support_entity_type";
    private final Set<Integer> supportEntityTypes;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(h r1) {
            this();
        }

        public final PersonalContextData createFromBundle(Bundle r2) {
            o.e(r2, "bundle");
            int[] r3 = r2.getIntArray(PersonalContextData.SUPPORT_ENTITY_TYPE_KEY);
            if (r3 == null) goto L6;
            Set<Integer> r4 = i.h(r3);
            if (r4 == null) goto L6;
        L8:
            return new PersonalContextData(r4);
        L6:
            r4 = EntityType.INSTANCE.getClassMap().keySet();
            goto L8
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PersonalContextData(Set<Integer> r3) {
        Set<Integer> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        o.e(r4, "supportEntityTypes");
        this.supportEntityTypes = r4;
    }

    public final void fillBundle(Bundle r2) {
        o.e(r2, "bundle");
        r2.putIntArray(SUPPORT_ENTITY_TYPE_KEY, p.e(this.supportEntityTypes));
    }

    public final Set<Integer> getSupportEntityTypes() {
        return this.supportEntityTypes;
    }
}
