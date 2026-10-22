package com.stepos.ailauncher.task.space;

import Ua.C1056g;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/task/space/ContentSafetyApi;", "", "<init>", "()V", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "BIZ_TYPE", "SCENE", "BASE_URL_KEY", "Ltb/x;", "JSON_MEDIA_TYPE", "Ltb/x;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ContentSafetyApi {
    public static final String BASE_URL_KEY = "securityAuditing";
    private static final String BIZ_TYPE = "ai_space_repair_room";
    public static final ContentSafetyApi INSTANCE = new ContentSafetyApi();
    private static final tb.x JSON_MEDIA_TYPE = tb.x.INSTANCE.a("application/json; charset=utf-8");
    private static final String SCENE = "ai_space_repair_room:identity_set";
    private static final String TAG = "AILauncher-ContentSafety";

    public final Object b(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new ContentSafetyApi$checkContent$2(str, null), interfaceC4014c);
    }
}
