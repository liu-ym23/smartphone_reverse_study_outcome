package com.stepos.core.deepbinder;

import com.stepos.deepbinder.annotation.type.Callback;
import kotlin.Metadata;

@Callback
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/core/deepbinder/IModelChangeListener;", "", "", "abilityId", "", "oldVersion", "newVersion", "installer", "LY8/t;", "onModelChanged", "(Ljava/lang/String;IILjava/lang/String;)V", "fromVersion", "toVersion", "reason", "onModelRollback", "onRecycle", "()V", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IModelChangeListener {
    void onModelChanged(String abilityId, int oldVersion, int newVersion, String installer);

    void onModelRollback(String abilityId, int fromVersion, int toVersion, String reason);

    void onRecycle();
}
