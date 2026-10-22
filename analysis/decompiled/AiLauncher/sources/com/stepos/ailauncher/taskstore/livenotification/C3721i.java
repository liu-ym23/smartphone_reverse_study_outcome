package com.stepos.ailauncher.taskstore.livenotification;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/i;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3721i {
    public static final C3721i INSTANCE = new C3721i();

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r4) {
        /*
            r3 = this;
            java.lang.String r3 = "card"
            kotlin.jvm.internal.p.i(r4, r3)
            java.lang.String r3 = r4.getSummary()
            r0 = 0
            if (r3 == 0) goto L1e
            boolean r1 = La.H.x0(r3)
            if (r1 != 0) goto L13
            goto L14
        L13:
            r3 = r0
        L14:
            if (r3 == 0) goto L1e
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r1 = r4.getStatus()
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r2 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.FAILED
            if (r1 != r2) goto L1f
        L1e:
            r3 = r0
        L1f:
            java.lang.String r1 = r4.getSubTitle()
            if (r1 == 0) goto L31
            boolean r2 = La.H.x0(r1)
            if (r2 != 0) goto L2c
            goto L2d
        L2c:
            r1 = r0
        L2d:
            if (r1 != 0) goto L30
            goto L31
        L30:
            return r1
        L31:
            if (r3 != 0) goto L46
            java.lang.String r3 = r4.getTitle()
            if (r3 == 0) goto L40
            boolean r4 = La.H.x0(r3)
            if (r4 != 0) goto L40
            r0 = r3
        L40:
            if (r0 != 0) goto L45
            java.lang.String r3 = ""
            return r3
        L45:
            return r0
        L46:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.C3721i.a(com.stepos.ailauncher.taskstore.entity.TaskInfoCard):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final String b(TaskInfoCard card) {
        List listM;
        Object next;
        String title;
        TaskInfoCard next2;
        List<TaskInfoCard> subTasks = card.getSubTasks();
        if (subTasks != null) {
            listM = new ArrayList();
            for (Object obj : subTasks) {
                String title2 = ((TaskInfoCard) obj).getTitle();
                if (!(title2 == null || La.H.x0(title2))) {
                    listM.add(obj);
                }
            }
        } else {
            listM = null;
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            TaskInfoCard taskInfoCard = (TaskInfoCard) obj2;
            if (taskInfoCard.getStatus() == TaskInfoStatus.IN_PROGRESS || taskInfoCard.getStatus() == TaskInfoStatus.RUNNING) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long createdAt = ((TaskInfoCard) next).getCreatedAt();
                do {
                    Object next3 = it.next();
                    long createdAt2 = ((TaskInfoCard) next3).getCreatedAt();
                    if (createdAt < createdAt2) {
                        next = next3;
                        createdAt = createdAt2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        TaskInfoCard taskInfoCard2 = (TaskInfoCard) next;
        if (taskInfoCard2 == null) {
            Iterator it2 = list.iterator();
            if (it2.hasNext()) {
                next2 = it2.next();
                if (it2.hasNext()) {
                    long createdAt3 = ((TaskInfoCard) next2).getCreatedAt();
                    do {
                        Object next4 = it2.next();
                        long createdAt4 = ((TaskInfoCard) next4).getCreatedAt();
                        next2 = next2;
                        if (createdAt3 < createdAt4) {
                            next2 = next4;
                            createdAt3 = createdAt4;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next2 = 0;
            }
            taskInfoCard2 = next2;
        }
        if (taskInfoCard2 == null || (title = taskInfoCard2.getTitle()) == null || La.H.x0(title)) {
            return null;
        }
        return title;
    }

    public final String c(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        String strA = a(card);
        String strB = b(card);
        if (strB != null) {
            return strB;
        }
        String str = null;
        if (La.H.x0(strA)) {
            strA = null;
        }
        if (strA != null) {
            return strA;
        }
        String title = card.getTitle();
        if (title != null && !La.H.x0(title)) {
            str = title;
        }
        if (str != null) {
            return str;
        }
        String type = card.getType();
        return La.H.x0(type) ? card.getTaskId() : type;
    }
}
