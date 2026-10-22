package com.uxsense.core;

import B9.C0177d;
import C7.r;
import D7.v;
import D7.w;
import S7.n;
import android.util.Log;
import androidx.core.location.LocationRequestCompat;
import com.uxsense.base.parse.ParseRule;
import com.uxsense.file.FileException;
import com.uxsense.file.FileResult;
import com.uxsense.file.FileStorageManager;
import g1.AbstractC1451a;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a(\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b\n\u0010\u000b\u001a0\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080@¢\u0006\u0004\b\r\u0010\u000e\u001aF\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0080@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/uxsense/core/ApexMetadataFileManager;", "", "packageName", "Lcom/uxsense/file/FileResult;", "", "Lcom/uxsense/base/parse/ParseRule;", "loadRules", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "rule", "LC7/r;", "saveRule", "(Lcom/uxsense/core/ApexMetadataFileManager;Lcom/uxsense/base/parse/ParseRule;LH7/c;)Ljava/lang/Object;", "rules", "saveRules", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "activityClass", "windowTitle", "appVersion", "", "deleteRule", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", "deleteAllRules", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ParseRuleExtensionsKt {

    @J7.c(c = "com.uxsense.core.ParseRuleExtensionsKt$deleteAllRules$2", f = "ParseRuleExtensions.kt", l = {145}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ParseRuleExtensionsKt$deleteAllRules$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $packageName;
        final /* synthetic */ ApexMetadataFileManager $this_deleteAllRules;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_deleteAllRules = apexMetadataFileManager;
            this.$packageName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$this_deleteAllRules, this.$packageName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            Path ruleFile = this.$this_deleteAllRules.getRuleFile(this.$packageName);
            FileStorageManager storage_$uxsense_release = this.$this_deleteAllRules.getStorage_$uxsense_release();
            this.label = 1;
            Object objDeleteFile = storage_$uxsense_release.deleteFile(ruleFile, this);
            return objDeleteFile == coroutineSingletons ? coroutineSingletons : objDeleteFile;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<Boolean>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ParseRuleExtensionsKt$deleteRule$2", f = "ParseRuleExtensions.kt", l = {LocationRequestCompat.QUALITY_LOW_POWER, 128, 148}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ParseRuleExtensionsKt$deleteRule$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12552 extends SuspendLambda implements n {
        final /* synthetic */ String $activityClass;
        final /* synthetic */ String $appVersion;
        final /* synthetic */ String $packageName;
        final /* synthetic */ ApexMetadataFileManager $this_deleteRule;
        final /* synthetic */ String $windowTitle;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12552(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, String str3, String str4, H7.c<? super C12552> cVar) {
            super(2, cVar);
            this.$this_deleteRule = apexMetadataFileManager;
            this.$packageName = str;
            this.$activityClass = str2;
            this.$windowTitle = str3;
            this.$appVersion = str4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(String str, String str2, String str3, String str4, ParseRule parseRule) {
            if (!k.b(parseRule.getPackageName(), str)) {
                return false;
            }
            if (str2 != null && !k.b(parseRule.getActivityClass(), str2)) {
                return false;
            }
            if (str3 == null || k.b(parseRule.getWindowTitle(), str3)) {
                return str4 == null || k.b(parseRule.getAppVersion(), str4);
            }
            return false;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12552(this.$this_deleteRule, this.$packageName, this.$activityClass, this.$windowTitle, this.$appVersion, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00d6  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.ParseRuleExtensionsKt.C12552.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<Integer>> cVar) {
            return ((C12552) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ParseRuleExtensionsKt$loadRules$2", f = "ParseRuleExtensions.kt", l = {148}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "Lcom/uxsense/base/parse/ParseRule;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ParseRuleExtensionsKt$loadRules$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12562 extends SuspendLambda implements n {
        final /* synthetic */ String $packageName;
        final /* synthetic */ ApexMetadataFileManager $this_loadRules;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12562(ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super C12562> cVar) {
            super(2, cVar);
            this.$this_loadRules = apexMetadataFileManager;
            this.$packageName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12562(this.$this_loadRules, this.$packageName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            Path ruleFile = this.$this_loadRules.getRuleFile(this.$packageName);
            if (!Files.exists(ruleFile, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                return new FileResult.Error(new FileException.FileNotFound(ruleFile));
            }
            FileStorageManager storage_$uxsense_release = this.$this_loadRules.getStorage_$uxsense_release();
            C0177d c0177dD = AbstractC1451a.d(ParseRule.INSTANCE.serializer());
            this.label = 1;
            Object json = storage_$uxsense_release.readJson(ruleFile, c0177dD, this);
            return json == coroutineSingletons ? coroutineSingletons : json;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<? extends List<ParseRule>>> cVar) {
            return ((C12562) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ParseRuleExtensionsKt$saveRule$2", f = "ParseRuleExtensions.kt", l = {31, 155}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ParseRuleExtensionsKt$saveRule$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12572 extends SuspendLambda implements n {
        final /* synthetic */ ParseRule $rule;
        final /* synthetic */ ApexMetadataFileManager $this_saveRule;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12572(ApexMetadataFileManager apexMetadataFileManager, ParseRule parseRule, H7.c<? super C12572> cVar) {
            super(2, cVar);
            this.$this_saveRule = apexMetadataFileManager;
            this.$rule = parseRule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12572(this.$this_saveRule, this.$rule, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Path ruleFile;
            ArrayList arrayList;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                ruleFile = this.$this_saveRule.getRuleFile(this.$rule.getPackageName());
                ApexMetadataFileManager apexMetadataFileManager = this.$this_saveRule;
                String packageName = this.$rule.getPackageName();
                this.L$0 = ruleFile;
                this.label = 1;
                obj = ParseRuleExtensionsKt.loadRules(apexMetadataFileManager, packageName, this);
                if (obj != coroutineSingletons) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            ruleFile = (Path) this.L$0;
            kotlin.b.b(obj);
            FileResult fileResult = (FileResult) obj;
            if (fileResult instanceof FileResult.Success) {
                arrayList = v.g1((Collection) ((FileResult.Success) fileResult).getData());
            } else {
                if (!(fileResult instanceof FileResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(((FileResult.Error) fileResult).getException() instanceof FileException.FileNotFound)) {
                    return fileResult;
                }
                arrayList = new ArrayList();
            }
            ParseRule parseRule = this.$rule;
            Iterator it = arrayList.iterator();
            int i6 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i6 = -1;
                    break;
                }
                ParseRule parseRule2 = (ParseRule) it.next();
                if (k.b(parseRule2.getPackageName(), parseRule.getPackageName()) && k.b(parseRule2.getWindowTitle(), parseRule.getWindowTitle())) {
                    break;
                }
                i6++;
            }
            if (i6 >= 0) {
                arrayList.set(i6, this.$rule);
            } else {
                arrayList.add(this.$rule);
            }
            Log.i("ApexMetadataManager", "saveRule: " + this.$rule);
            FileStorageManager storage_$uxsense_release = this.$this_saveRule.getStorage_$uxsense_release();
            C0177d c0177dD = AbstractC1451a.d(ParseRule.INSTANCE.serializer());
            this.L$0 = null;
            this.label = 2;
            Object objWriteJson = storage_$uxsense_release.writeJson(ruleFile, arrayList, c0177dD, this);
            return objWriteJson == coroutineSingletons ? coroutineSingletons : objWriteJson;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12572) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ParseRuleExtensionsKt$saveRules$2", f = "ParseRuleExtensions.kt", l = {155}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ParseRuleExtensionsKt$saveRules$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12582 extends SuspendLambda implements n {
        final /* synthetic */ String $packageName;
        final /* synthetic */ List<ParseRule> $rules;
        final /* synthetic */ ApexMetadataFileManager $this_saveRules;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12582(ApexMetadataFileManager apexMetadataFileManager, String str, List<ParseRule> list, H7.c<? super C12582> cVar) {
            super(2, cVar);
            this.$this_saveRules = apexMetadataFileManager;
            this.$packageName = str;
            this.$rules = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12582(this.$this_saveRules, this.$packageName, this.$rules, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            Path ruleFile = this.$this_saveRules.getRuleFile(this.$packageName);
            List<ParseRule> list = this.$rules;
            String str = this.$packageName;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (!k.b(((ParseRule) obj2).getPackageName(), str)) {
                    arrayList.add(obj2);
                }
            }
            if (arrayList.isEmpty()) {
                FileStorageManager storage_$uxsense_release = this.$this_saveRules.getStorage_$uxsense_release();
                List<ParseRule> list2 = this.$rules;
                C0177d c0177dD = AbstractC1451a.d(ParseRule.INSTANCE.serializer());
                this.label = 1;
                Object objWriteJson = storage_$uxsense_release.writeJson(ruleFile, list2, c0177dD, this);
                return objWriteJson == coroutineSingletons ? coroutineSingletons : objWriteJson;
            }
            StringBuilder sb = new StringBuilder("规则中存在不匹配的 packageName: ");
            ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ParseRule) it.next()).getPackageName());
            }
            sb.append(arrayList2);
            return new FileResult.Error(new FileException.WriteError(ruleFile, new IllegalArgumentException(sb.toString())));
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12582) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static final Object deleteAllRules(ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super FileResult<Boolean>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(apexMetadataFileManager, str, null), cVar);
    }

    public static final Object deleteRule(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, String str3, String str4, H7.c<? super FileResult<Integer>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12552(apexMetadataFileManager, str, str2, str3, str4, null), cVar);
    }

    public static /* synthetic */ Object deleteRule$default(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, String str3, String str4, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        return deleteRule(apexMetadataFileManager, str, str2, str3, str4, cVar);
    }

    public static final Object loadRules(ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super FileResult<? extends List<ParseRule>>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12562(apexMetadataFileManager, str, null), cVar);
    }

    public static final Object saveRule(ApexMetadataFileManager apexMetadataFileManager, ParseRule parseRule, H7.c<? super FileResult<r>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12572(apexMetadataFileManager, parseRule, null), cVar);
    }

    public static final Object saveRules(ApexMetadataFileManager apexMetadataFileManager, String str, List<ParseRule> list, H7.c<? super FileResult<r>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12582(apexMetadataFileManager, str, list, null), cVar);
    }
}
