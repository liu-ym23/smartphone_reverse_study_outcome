package com.stepos.ailauncher.taskstore;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u0007¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/taskstore/i;", "", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "cards", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "taskIds", Const.INTENT_KEY_UMID, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface i {
    static /* synthetic */ Object a(i iVar, List<TaskInfoCard> list, InterfaceC4014c<? super t> interfaceC4014c) {
        return t.f7040a;
    }

    static /* synthetic */ Object c(i iVar, List<String> list, InterfaceC4014c<? super t> interfaceC4014c) {
        return t.f7040a;
    }

    default Object b(List<TaskInfoCard> list, InterfaceC4014c<? super t> interfaceC4014c) {
        return a(this, list, interfaceC4014c);
    }

    default Object d(List<String> list, InterfaceC4014c<? super t> interfaceC4014c) {
        return c(this, list, interfaceC4014c);
    }
}
