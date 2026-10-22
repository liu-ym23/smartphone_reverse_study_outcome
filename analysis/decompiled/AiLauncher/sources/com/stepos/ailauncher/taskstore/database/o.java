package com.stepos.ailauncher.taskstore.database;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H§@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/o;", "", "", "taskId", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "taskVersion", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/taskstore/database/t;", Const.LBS_FAIL_BD_ENTITY, "", "c", "(Lcom/stepos/ailauncher/taskstore/database/t;Le9/c;)Ljava/lang/Object;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface o {
    Object a(String str, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object b(String str, int i10, InterfaceC4014c<? super Boolean> interfaceC4014c);

    Object c(TaskSubTaskSnapshotEntity taskSubTaskSnapshotEntity, InterfaceC4014c<? super Long> interfaceC4014c);
}
