package com.stepos.ailauncher.taskstore.dao;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.vector.LauncherVectorEntity;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\b\u0010\u0006J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH§@¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH§@¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0011\u001a\u00020\rH§@¢\u0006\u0004\b\u0012\u0010\u0010¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/taskstore/dao/a;", "", "Lcom/stepos/ailauncher/taskstore/vector/a;", Const.LBS_FAIL_BD_ENTITY, "", "c", "(Lcom/stepos/ailauncher/taskstore/vector/a;Le9/c;)Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_UMID, "", "ids", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "bizKey", "e", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "bizType", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.dao.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC3710a {
    Object a(String str, InterfaceC4014c<? super List<LauncherVectorEntity>> interfaceC4014c);

    Object b(List<Long> list, InterfaceC4014c<? super List<LauncherVectorEntity>> interfaceC4014c);

    Object c(LauncherVectorEntity launcherVectorEntity, InterfaceC4014c<? super Long> interfaceC4014c);

    Object d(LauncherVectorEntity launcherVectorEntity, InterfaceC4014c<? super Y8.t> interfaceC4014c);

    Object e(String str, InterfaceC4014c<? super LauncherVectorEntity> interfaceC4014c);
}
