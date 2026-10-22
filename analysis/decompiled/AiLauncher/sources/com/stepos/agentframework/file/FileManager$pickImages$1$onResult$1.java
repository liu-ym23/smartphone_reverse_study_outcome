package com.stepos.agentframework.file;

import Ua.M;
import Y8.t;
import android.net.Uri;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.file.FileManager;
import com.zyql.ai.selector.entity.LocalMedia;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.file.FileManager$pickImages$1$onResult$1", f = "FileManager.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class FileManager$pickImages$1$onResult$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ FileManager.a $pickListener;
    final /* synthetic */ List<LocalMedia> $selectedList;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.file.FileManager$pickImages$1$onResult$1$2", f = "FileManager.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.file.FileManager$pickImages$1$onResult$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ List<FileInfo> $images;
        final /* synthetic */ FileManager.a $pickListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(FileManager.a aVar, List<FileInfo> list, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$pickListener = aVar;
            this.$images = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$pickListener, this.$images, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$pickListener.a(this.$images);
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileManager$pickImages$1$onResult$1(List<? extends LocalMedia> list, FileManager.a aVar, InterfaceC4014c<? super FileManager$pickImages$1$onResult$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$selectedList = list;
        this.$pickListener = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FileManager$pickImages$1$onResult$1(this.$selectedList, this.$pickListener, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FileManager$pickImages$1$onResult$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        ArrayList arrayList = new ArrayList();
        for (LocalMedia localMedia : this.$selectedList) {
            String strValueOf = String.valueOf(localMedia.getId());
            String fileName = localMedia.getFileName();
            kotlin.jvm.internal.p.h(fileName, "getFileName(...)");
            String path = localMedia.getPath();
            kotlin.jvm.internal.p.h(path, "getPath(...)");
            Uri uri = Uri.parse(path);
            String strValueOf2 = String.valueOf(localMedia.getSize());
            String realPath = localMedia.getRealPath();
            kotlin.jvm.internal.p.h(realPath, "getRealPath(...)");
            arrayList.add(new FileInfo(strValueOf, fileName, uri, 1, strValueOf2, realPath, "", null, null, null, 0, null, false, 8064, null));
        }
        Function2.b(new AnonymousClass2(this.$pickListener, arrayList, null));
        return t.f7040a;
    }
}
