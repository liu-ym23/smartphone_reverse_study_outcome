package X6;

import F9.C0234l;
import a7.AbstractC0308d;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.bucket.DeleteBucketWebsiteOutput;
import com.volcengine.tos.model.bucket.PutBucketRealTimeLogOutput;
import com.volcengine.tos.model.object.AbortMultipartUploadOutput;
import com.volcengine.tos.model.object.CreateMultipartUploadOutput;
import com.volcengine.tos.model.object.DeleteObjectOutput;
import com.volcengine.tos.model.object.DeleteObjectTaggingOutput;
import com.volcengine.tos.model.object.ListObjectsType2Output;
import com.volcengine.tos.model.object.PutObjectACLOutput;
import com.volcengine.tos.model.object.PutObjectTaggingOutput;
import com.volcengine.tos.model.object.RenameObjectOutput;
import com.volcengine.tos.model.object.SetObjectMetaOutput;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements a, DoubleFunction, ShouldPauseCallback, TextInclusionStrategy, VisualTransformation, Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1512a;

    public /* synthetic */ h(int i) {
        this.f1512a = i;
    }

    @Override // X6.a
    public Object c(TosResponse tosResponse) {
        switch (this.f1512a) {
            case 0:
                return new DeleteBucketWebsiteOutput().setRequestInfo(tosResponse.b());
            case 1:
                return new PutBucketRealTimeLogOutput().setRequestInfo(tosResponse.b());
            case 2:
                return ((ListObjectsType2Output) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 3:
                return new DeleteObjectTaggingOutput().setRequestInfo(tosResponse.b()).setVersionID(tosResponse.c("X-Tos-Version-Id"));
            case 4:
                return new RenameObjectOutput().setRequestInfo(tosResponse.b());
            case 5:
                return new PutObjectACLOutput().requestInfo(tosResponse.b());
            case 6:
                return new AbortMultipartUploadOutput().setRequestInfo(tosResponse.b());
            case 7:
                return new DeleteObjectOutput().setRequestInfo(tosResponse.b()).setDeleteMarker(Boolean.parseBoolean(tosResponse.c("X-Tos-Delete-Marker"))).setVersionID(tosResponse.c("X-Tos-Version-Id"));
            case 8:
                return new SetObjectMetaOutput().setRequestInfo(tosResponse.b());
            case 9:
                return new PutObjectTaggingOutput().setRequestInfo(tosResponse.b()).setVersionID(tosResponse.c("X-Tos-Version-Id"));
            default:
                if (AbstractC0308d.a(tosResponse.d, new e()) != null) {
                    throw new ClassCastException();
                }
                new CreateMultipartUploadOutput().setRequestInfo(tosResponse.b());
                throw null;
        }
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText filter(AnnotatedString annotatedString) {
        return VisualTransformation.Companion.None$lambda$0(annotatedString);
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        switch (this.f1512a) {
            case 23:
                return Transition.lambda$getInterpolator$1(f);
            case 24:
                return Transition.lambda$getInterpolator$2(f);
            case 25:
                return Transition.lambda$getInterpolator$3(f);
            case 26:
                return Transition.lambda$getInterpolator$4(f);
            case 27:
                return Transition.lambda$getInterpolator$5(f);
            case 28:
                return Transition.lambda$getInterpolator$6(f);
            default:
                return Transition.lambda$getInterpolator$7(f);
        }
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public double invoke(double d) {
        switch (this.f1512a) {
            case 11:
                return ColorSpaces.ExtendedSrgb$lambda$0(d);
            case 12:
                return ColorSpaces.ExtendedSrgb$lambda$1(d);
            case 13:
                return ColorSpaces.Bt2020Hlg$lambda$2(d);
            case 14:
                return ColorSpaces.Bt2020Hlg$lambda$3(d);
            case 15:
                return ColorSpaces.Bt2020Pq$lambda$4(d);
            case 16:
                return ColorSpaces.Bt2020Pq$lambda$5(d);
            default:
                return Rgb.DoubleIdentity$lambda$8(d);
        }
    }

    @Override // androidx.compose.ui.text.TextInclusionStrategy
    public boolean isIncluded(Rect rect, Rect rect2) {
        switch (this.f1512a) {
            case 19:
                return rect.overlaps(rect2);
            case 20:
                return TextInclusionStrategy.Companion.ContainsAll$lambda$1(rect, rect2);
            default:
                return TextInclusionStrategy.Companion.ContainsCenter$lambda$2(rect, rect2);
        }
    }

    @Override // androidx.compose.runtime.ShouldPauseCallback
    public boolean shouldPause() {
        return LayoutNodeSubcompositionsState.applyPausedPrecomposition$lambda$28$lambda$27$lambda$26();
    }

    public /* synthetic */ h(C0234l c0234l, int i) {
        this.f1512a = i;
    }
}
