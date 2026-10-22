package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HasDefaultViewModelProviderFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public interface g {
    am.b getDefaultViewModelProviderFactory();

    default androidx.lifecycle.a.a getDefaultViewModelCreationExtras() {
        return (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(androidx.lifecycle.a.a.C0057a.f1967a, androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
    }
}
