package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/vl;", "", "", "taskStatus", "I", "getTaskStatus", "()I", "setTaskStatus", "(I)V", "", "taskClassId", "J", "getTaskClassId", "()J", "setTaskClassId", "(J)V", "", "Lcom/bytedance/android/livesdk/message/model/yl;", "todos", "Ljava/util/List;", "getTodos", "()Ljava/util/List;", "setTodos", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/message/model/ul;", "currentInfo", "Lcom/bytedance/android/livesdk/message/model/ul;", "getCurrentInfo", "()Lcom/bytedance/android/livesdk/message/model/ul;", "setCurrentInfo", "(Lcom/bytedance/android/livesdk/message/model/ul;)V", "wishType", "getWishType", "setWishType", "Lcom/bytedance/android/livesdk/message/model/un;", "wishContributor", "Lcom/bytedance/android/livesdk/message/model/un;", "getWishContributor", "()Lcom/bytedance/android/livesdk/message/model/un;", "setWishContributor", "(Lcom/bytedance/android/livesdk/message/model/un;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class vl implements vh7.h {

    @SerializedName("current_info")
    protected ul currentInfo;

    @SerializedName("task_class_id")
    protected long taskClassId;

    @SerializedName("task_status")
    protected int taskStatus;

    @SerializedName("todos")
    protected List<yl> todos;

    @SerializedName("wish_contributor")
    protected un wishContributor;

    @SerializedName("wish_type")
    protected int wishType;

    public vl() {
    }

    public vl(am3.g r100) {
        this.todos = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.wishContributor = new un(r100);
        goto L3
    L8:
        this.wishType = r100.i();
        goto L3
    L9:
        this.currentInfo = new ul(r100);
        goto L3
    L10:
        this.todos.add(new yl(r100));
        goto L3
    L11:
        this.taskClassId = r100.j();
        goto L3
    L12:
        this.taskStatus = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
