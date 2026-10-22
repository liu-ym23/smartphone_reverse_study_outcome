package com.stepos.agentframework.file;

import Ua.M;
import Y8.t;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.d;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.utils.g;
import com.stepos.agentframework.chatcore.utils.h;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.file.FileManager$handlePickerLauncherResult$1", f = "FileManager.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class FileManager$handlePickerLauncherResult$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ d $activity;
    final /* synthetic */ ActivityResult $result;
    int label;
    final /* synthetic */ FileManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileManager$handlePickerLauncherResult$1(ActivityResult activityResult, FileManager fileManager, d dVar, InterfaceC4014c<? super FileManager$handlePickerLauncherResult$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$result = activityResult;
        this.this$0 = fileManager;
        this.$activity = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FileManager$handlePickerLauncherResult$1(this.$result, this.this$0, this.$activity, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FileManager$handlePickerLauncherResult$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Uri data;
        String strA;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Intent data2 = this.$result.getData();
        if (data2 != null && (data = data2.getData()) != null) {
            FileManager fileManager = this.this$0;
            d dVar = this.$activity;
            C4148a.d(fileManager.TAG, "filePath: " + data, false, 4, null);
            N0.a aVarA = N0.a.a(dVar, data);
            if (aVarA == null || (strA = h.a(aVarA.b())) == null) {
                strA = "0 M";
            }
            C4148a.d(fileManager.TAG, "file size: " + strA, false, 4, null);
            ArrayList arrayList = new ArrayList();
            String strD = fileManager.d(dVar, data);
            FileInfo fileInfo = new FileInfo(String.valueOf(System.currentTimeMillis()), g.INSTANCE.e(dVar, data), data, fileManager.k(strD), strA, "", "", null, null, null, 0, null, false, 8064, null);
            C4148a.k(fileManager.TAG, "selected fileInfo: " + fileInfo + " fileType:" + strD, false, 4, null);
            String strC = fileManager.c(fileInfo.getFileUri());
            if (strC == null) {
                strC = "";
            }
            fileInfo.setFilePath(strC);
            arrayList.add(fileInfo);
            Function2.b(new FileManager$handlePickerLauncherResult$1$1$1(fileManager, arrayList, null));
        }
        return t.f7040a;
    }
}
