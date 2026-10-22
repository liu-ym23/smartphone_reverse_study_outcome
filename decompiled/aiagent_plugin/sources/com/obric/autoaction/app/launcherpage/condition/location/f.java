package com.obric.autoaction.app.launcherpage.condition.location;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FrequentLocationEditComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: compiled from: FrequentLocationEditComponent.kt */
    public static final class a implements com.obric.autoaction.app.launcherpage.condition.config.condition.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f23181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f23182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Double f23183c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Double f23184d;

        a(ConditionLocationItemData r3) {
            this.f23181a = r3.getName();
            this.f23182b = Integer.valueOf(r3.getType());
            this.f23183c = Double.valueOf(r3.getLongitude());
            this.f23184d = Double.valueOf(r3.getLatitude());
        }

        @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.g
        public Integer getLocationType() {
            return this.f23182b;
        }

        @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.g
        public Double getLongitude() {
            return this.f23183c;
        }

        @Override // com.obric.autoaction.app.launcherpage.condition.config.condition.g
        public Double getLatitude() {
            return this.f23184d;
        }
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.condition.config.condition.g a(ConditionLocationItemData r0) {
        return b(r0);
    }

    private static final com.obric.autoaction.app.launcherpage.condition.config.condition.g b(ConditionLocationItemData r2) {
        return (com.obric.autoaction.app.launcherpage.condition.config.condition.g) ZeusTransformUtils.preCheckCast(new a(r2), com.obric.autoaction.app.launcherpage.condition.config.condition.g.class, "com.obric.aiagent.plugin");
    }
}
