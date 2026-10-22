package com.stepos.ability.api.ability.permission;

import android.content.Context;
import com.stepos.ability.bean.SlaPermissionResult;
import com.stepos.ability.commoninternal.Key;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/api/ability/permission/ISlaPermissionManager;", "", "", "", "functions", "Lcom/stepos/ability/bean/SlaPermissionResult;", "checkSlaPermission", "(Ljava/util/List;)Lcom/stepos/ability/bean/SlaPermissionResult;", "Landroid/content/Context;", "context", "LC7/r;", "warmUp", "(Landroid/content/Context;)V", "", "loggedIn", "onAccountLoginStateChanged", "(Z)V", "onNetworkAvailable", "()V", Key.KEY_TOOL_CALL_ID, "onAuthCardDecided", "(Ljava/lang/String;)V", "api_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ISlaPermissionManager {
    SlaPermissionResult checkSlaPermission(List<String> functions);

    void onAccountLoginStateChanged(boolean loggedIn);

    void onAuthCardDecided(String toolCallId);

    void onNetworkAvailable();

    void warmUp(Context context);
}
