package com.stepos.ailauncher.taskstore.chat;

import Z8.C1173v;
import Z8.C1174w;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.view.FloatInputView;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoContentType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPartType;
import com.stepos.ailauncher.taskstore.read.TaskReadStateManager;
import com.stepos.ailauncher.taskstore.widget.C3735a;
import com.stepos.ailauncher.taskstore.widget.InterfaceC3745k;
import com.stepos.ailauncher.taskstore.widget.TextToImageCardView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u001c*\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/e;", "Lcom/stepos/agentframework/chatui/appui/a;", "Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView;", "Lcom/google/gson/JsonElement;", "<init>", "()V", "Landroid/view/View;", "view", "", "taskId", "LY8/t;", "m", "(Landroid/view/View;Ljava/lang/String;)V", "", "k", "()Z", "data", "l", "(Lcom/google/gson/JsonElement;)V", "Landroid/content/Context;", "context", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;)Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/ailauncher/taskstore/chat/I;", "n", "(Lcom/google/gson/JsonElement;)Lcom/stepos/ailauncher/taskstore/chat/I;", "Lcom/stepos/ailauncher/taskstore/chat/H;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "o", "(Lcom/stepos/ailauncher/taskstore/chat/H;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "Ljava/lang/String;", "versionId", "", "initialArtifacts", "Ljava/util/List;", "generationSuppressed", "Z", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.chat.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3702e extends com.stepos.agentframework.chatui.appui.a<TextToImageCardView, JsonElement> {
    private static final String ACTION_OPEN_TASK_DETAIL = "com.stepos.ailauncher.task.DETAIL_ACTION";
    private static final Gson GSON = new Gson();
    private static final String TAG = "ChatTextToImageCardBridge";
    private boolean generationSuppressed;
    private List<TaskInfoPart> initialArtifacts = C1173v.m();
    private String taskId;
    private String versionId;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/chat/e$b", "Lcom/stepos/ailauncher/taskstore/widget/k;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.chat.e$b */
    public static final class b implements InterfaceC3745k {
        final /* synthetic */ TextToImageCardView $view;

        public b(TextToImageCardView textToImageCardView) {
            this.$view = textToImageCardView;
        }

        @Override // com.stepos.ailauncher.taskstore.widget.InterfaceC3745k
        public void a(TaskInfoCard card) {
            if (card == null) {
                return;
            }
            C3702e.this.m(this.$view, card.getTaskId());
        }
    }

    private final boolean k() {
        return InputViewManager.INSTANCE.r0() instanceof FloatInputView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(View view, String taskId) {
        TaskReadStateManager.INSTANCE.a(taskId, "ChatTextToImageCardBridge.openTaskDetail");
        Intent intent = new Intent("com.stepos.ailauncher.task.DETAIL_ACTION");
        intent.setPackage(view.getContext().getPackageName());
        intent.putExtra("taskId", taskId);
        intent.putExtra("fromChatView", k());
        if (!(view.getContext() instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        view.getContext().startActivity(intent);
        WakeService.Companion companion = WakeService.INSTANCE;
        Context context = view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        WakeService.Companion.a0(companion, context, false, 2, null);
    }

    @Override // com.stepos.agentframework.chatui.appui.a
    public void g() throws Exception {
        String str = this.taskId;
        if (str != null) {
            B b10 = B.INSTANCE;
            String str2 = null;
            if (str == null) {
                kotlin.jvm.internal.p.A("taskId");
                str = null;
            }
            TextToImageCardView textToImageCardViewQ = b10.Q(str, this.versionId);
            if (textToImageCardViewQ != null && textToImageCardViewQ == c()) {
                String str3 = this.taskId;
                if (str3 == null) {
                    kotlin.jvm.internal.p.A("taskId");
                } else {
                    str2 = str3;
                }
                b10.t0(str2, this.versionId);
            }
        }
        TextToImageCardView textToImageCardViewC = c();
        if (textToImageCardViewC != null) {
            textToImageCardViewC.J0();
        }
    }

    @Override // com.stepos.agentframework.chatui.appui.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public TextToImageCardView b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        String str = this.taskId;
        String str2 = null;
        if (str == null) {
            kotlin.jvm.internal.p.A("taskId");
            str = null;
        }
        TextToImageCardView textToImageCardView = new TextToImageCardView(context, str, this.versionId);
        textToImageCardView.setActionListener(new b(textToImageCardView));
        if (this.generationSuppressed) {
            textToImageCardView.setVisibility(8);
            return textToImageCardView;
        }
        B b10 = B.INSTANCE;
        String str3 = this.taskId;
        if (str3 == null) {
            kotlin.jvm.internal.p.A("taskId");
            str3 = null;
        }
        b10.a0(str3, this.versionId, textToImageCardView);
        if (!this.initialArtifacts.isEmpty()) {
            String str4 = this.taskId;
            if (str4 == null) {
                kotlin.jvm.internal.p.A("taskId");
            } else {
                str2 = str4;
            }
            if (b10.L(str2, this.versionId).isEmpty()) {
                textToImageCardView.Y(this.initialArtifacts);
            }
        }
        C3735a.a(textToImageCardView);
        return textToImageCardView;
    }

    @Override // com.stepos.agentframework.chatui.appui.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f(JsonElement data) {
        kotlin.jvm.internal.p.i(data, "data");
        TaskResultFilePayload taskResultFilePayloadN = n(data);
        String str = null;
        String taskId = taskResultFilePayloadN != null ? taskResultFilePayloadN.getTaskId() : null;
        if (taskId == null) {
            taskId = "";
        }
        this.taskId = taskId;
        this.versionId = taskResultFilePayloadN != null ? taskResultFilePayloadN.getVersionId() : null;
        List<TaskResultFileItem> listB = taskResultFilePayloadN != null ? taskResultFilePayloadN.b() : null;
        if (listB == null) {
            listB = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listB) {
            if (L.c((TaskResultFileItem) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(o((TaskResultFileItem) it.next()));
        }
        this.initialArtifacts = arrayList2;
        List<String> listA = taskResultFilePayloadN != null ? taskResultFilePayloadN.a() : null;
        if (listA == null) {
            listA = C1173v.m();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listA) {
            if (!La.H.x0((String) obj2)) {
                arrayList3.add(obj2);
            }
        }
        List listG0 = Z8.F.g0(arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : listG0) {
            if (!B.INSTANCE.U((String) obj3)) {
                arrayList4.add(obj3);
            }
        }
        this.generationSuppressed = !listG0.isEmpty() && arrayList4.isEmpty();
        if (!arrayList4.isEmpty()) {
            String str2 = this.taskId;
            if (str2 == null) {
                kotlin.jvm.internal.p.A("taskId");
                str2 = null;
            }
            if (!La.H.x0(str2)) {
                B b10 = B.INSTANCE;
                String str3 = this.taskId;
                if (str3 == null) {
                    kotlin.jvm.internal.p.A("taskId");
                    str3 = null;
                }
                b10.b0(str3, arrayList4, this.versionId);
            }
        }
        String str4 = this.taskId;
        if (str4 == null) {
            kotlin.jvm.internal.p.A("taskId");
        } else {
            str = str4;
        }
        Log.i(TAG, "onInitData: taskId=" + str + " versionId=" + this.versionId + " initialArtifacts=" + this.initialArtifacts.size() + " pendingToolCalls=" + listG0.size());
    }

    public final TaskResultFilePayload n(JsonElement data) {
        Object objB;
        if (data.isJsonPrimitive() && data.getAsJsonPrimitive().isString()) {
            return new TaskResultFilePayload(data.getAsString(), null, null, null, 14, null);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((TaskResultFilePayload) GSON.fromJson(data, TaskResultFilePayload.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (TaskResultFilePayload) objB;
    }

    public final TaskInfoPart o(TaskResultFileItem taskResultFileItem) {
        TaskInfoPartType taskInfoPartType = TaskInfoPartType.IMAGE;
        TaskInfoContentType taskInfoContentType = TaskInfoContentType.FILE;
        String fileId = taskResultFileItem.getFileId();
        String cloudPath = taskResultFileItem.getCloudPath();
        if (cloudPath == null) {
            cloudPath = "";
        }
        return new TaskInfoPart(null, null, taskInfoPartType, taskInfoContentType, fileId, cloudPath, taskResultFileItem.getFileName(), taskResultFileItem.getTitle(), taskResultFileItem.getMimeType(), taskResultFileItem.getSize(), null, 0, null, null, 15363, null);
    }
}
