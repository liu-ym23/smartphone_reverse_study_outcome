package com.stepos.ailauncher.task.detail.fragment;

import Ua.C1056g;
import Ua.M;
import Ua.Y;
import Z8.C1172u;
import android.view.View;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.task.common.ArtifactAvailabilityStore;
import com.stepos.ailauncher.task.detail.render.ArtifactContentView;
import com.stepos.ailauncher.task.detail.version.ArtifactVersions;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$renderArtifact$1", f = "ArtifactDetailFragment.kt", l = {485}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactDetailFragment$renderArtifact$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ SessionArtifact $art;
    final /* synthetic */ ArtifactContentView $content;
    final /* synthetic */ String $fileId;
    int label;
    final /* synthetic */ ArtifactDetailFragment this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArtifactAvailability.values().length];
            try {
                iArr[ArtifactAvailability.BLOCKED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArtifactAvailability.UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDetailFragment$renderArtifact$1(ArtifactDetailFragment artifactDetailFragment, String str, ArtifactContentView artifactContentView, SessionArtifact sessionArtifact, InterfaceC4014c<? super ArtifactDetailFragment$renderArtifact$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = artifactDetailFragment;
        this.$fileId = str;
        this.$content = artifactContentView;
        this.$art = sessionArtifact;
    }

    public static final Y8.t i(final ArtifactDetailFragment artifactDetailFragment, final String str, final ArtifactContentView artifactContentView, final Map map) {
        View view = artifactDetailFragment.getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.fragment.K
                @Override // java.lang.Runnable
                public final void run() {
                    ArtifactDetailFragment$renderArtifact$1.n(artifactDetailFragment, str, map, artifactContentView);
                }
            });
        }
        return Y8.t.f7040a;
    }

    public static final void n(ArtifactDetailFragment artifactDetailFragment, String str, Map map, ArtifactContentView artifactContentView) {
        SessionArtifact sessionArtifactE;
        if (artifactDetailFragment.isAdded()) {
            ArtifactVersions artifactVersions = artifactDetailFragment.versions;
            if (kotlin.jvm.internal.p.d((artifactVersions == null || (sessionArtifactE = artifactVersions.e()) == null) ? null : sessionArtifactE.getFileId(), str)) {
                ArtifactAvailability artifactAvailability = (ArtifactAvailability) map.get(str);
                int i10 = artifactAvailability == null ? -1 : a.$EnumSwitchMapping$0[artifactAvailability.ordinal()];
                if (i10 == 1) {
                    artifactContentView.M1();
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    artifactContentView.N1();
                }
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactDetailFragment$renderArtifact$1(this.this$0, this.$fileId, this.$content, this.$art, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ArtifactDetailFragment$renderArtifact$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SessionArtifact sessionArtifactE;
        Object objG = C4063a.g();
        int i10 = this.label;
        String fileId = null;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Y.b();
            ArtifactDetailFragment$renderArtifact$1$cached$1 artifactDetailFragment$renderArtifact$1$cached$1 = new ArtifactDetailFragment$renderArtifact$1$cached$1(this.$fileId, null);
            this.label = 1;
            obj = C1056g.j(iB, artifactDetailFragment$renderArtifact$1$cached$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        ArtifactAvailability artifactAvailability = (ArtifactAvailability) obj;
        if (this.this$0.isAdded()) {
            ArtifactVersions artifactVersions = this.this$0.versions;
            if (artifactVersions != null && (sessionArtifactE = artifactVersions.e()) != null) {
                fileId = sessionArtifactE.getFileId();
            }
            if (kotlin.jvm.internal.p.d(fileId, this.$fileId)) {
                if (artifactAvailability == ArtifactAvailability.BLOCKED) {
                    this.$content.M1();
                    return Y8.t.f7040a;
                }
                if (artifactAvailability == ArtifactAvailability.UNAVAILABLE) {
                    this.$content.N1();
                    return Y8.t.f7040a;
                }
                ArtifactAvailabilityStore artifactAvailabilityStore = ArtifactAvailabilityStore.INSTANCE;
                List<String> listE = C1172u.e(this.$fileId);
                final ArtifactDetailFragment artifactDetailFragment = this.this$0;
                final String str = this.$fileId;
                final ArtifactContentView artifactContentView = this.$content;
                artifactAvailabilityStore.t(listE, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.fragment.J
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj2) {
                        return ArtifactDetailFragment$renderArtifact$1.i(artifactDetailFragment, str, artifactContentView, (Map) obj2);
                    }
                });
                if (M5.c.INSTANCE.y(this.$art.getFileName(), this.$art.getMimeType())) {
                    this.this$0.O0(this.$art);
                } else {
                    this.$content.o1(this.$art);
                }
                return Y8.t.f7040a;
            }
        }
        return Y8.t.f7040a;
    }
}
