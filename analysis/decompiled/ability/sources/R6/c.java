package R6;

import F.g;
import F9.C0234l;
import M0.k;
import X6.h;
import X6.i;
import X6.j;
import X6.n;
import X6.o;
import Z6.e;
import a.AbstractC0291a;
import a7.AbstractC0306b;
import a7.AbstractC0307c;
import a7.AbstractC0308d;
import a7.f;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ca.AbstractC0897f;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.volcengine.tos.TOSV2;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.TosException;
import com.volcengine.tos.comm.common.CannedType;
import com.volcengine.tos.comm.common.GranteeType;
import com.volcengine.tos.comm.common.PermissionType;
import com.volcengine.tos.comm.event.CopyEventType;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.acl.ACLConst;
import com.volcengine.tos.model.acl.GetObjectAclOutput;
import com.volcengine.tos.model.acl.Grant;
import com.volcengine.tos.model.acl.GrantV2;
import com.volcengine.tos.model.acl.Grantee;
import com.volcengine.tos.model.acl.GranteeV2;
import com.volcengine.tos.model.acl.Owner;
import com.volcengine.tos.model.acl.PutObjectAclInput;
import com.volcengine.tos.model.acl.PutObjectAclOutput;
import com.volcengine.tos.model.bucket.CreateBucketInput;
import com.volcengine.tos.model.bucket.CreateBucketOutput;
import com.volcengine.tos.model.bucket.CreateBucketV2Input;
import com.volcengine.tos.model.bucket.CreateBucketV2Output;
import com.volcengine.tos.model.bucket.DeleteBucketCORSInput;
import com.volcengine.tos.model.bucket.DeleteBucketCORSOutput;
import com.volcengine.tos.model.bucket.DeleteBucketCustomDomainInput;
import com.volcengine.tos.model.bucket.DeleteBucketCustomDomainOutput;
import com.volcengine.tos.model.bucket.DeleteBucketInput;
import com.volcengine.tos.model.bucket.DeleteBucketLifecycleInput;
import com.volcengine.tos.model.bucket.DeleteBucketLifecycleOutput;
import com.volcengine.tos.model.bucket.DeleteBucketMirrorBackInput;
import com.volcengine.tos.model.bucket.DeleteBucketMirrorBackOutput;
import com.volcengine.tos.model.bucket.DeleteBucketOutput;
import com.volcengine.tos.model.bucket.DeleteBucketPolicyInput;
import com.volcengine.tos.model.bucket.DeleteBucketPolicyOutput;
import com.volcengine.tos.model.bucket.DeleteBucketRealTimeLogInput;
import com.volcengine.tos.model.bucket.DeleteBucketRealTimeLogOutput;
import com.volcengine.tos.model.bucket.DeleteBucketRenameInput;
import com.volcengine.tos.model.bucket.DeleteBucketRenameOutput;
import com.volcengine.tos.model.bucket.DeleteBucketReplicationInput;
import com.volcengine.tos.model.bucket.DeleteBucketReplicationOutput;
import com.volcengine.tos.model.bucket.DeleteBucketWebsiteInput;
import com.volcengine.tos.model.bucket.DeleteBucketWebsiteOutput;
import com.volcengine.tos.model.bucket.GetBucketACLInput;
import com.volcengine.tos.model.bucket.GetBucketACLOutput;
import com.volcengine.tos.model.bucket.GetBucketCORSInput;
import com.volcengine.tos.model.bucket.GetBucketCORSOutput;
import com.volcengine.tos.model.bucket.GetBucketLifecycleInput;
import com.volcengine.tos.model.bucket.GetBucketLifecycleOutput;
import com.volcengine.tos.model.bucket.GetBucketLocationInput;
import com.volcengine.tos.model.bucket.GetBucketLocationOutput;
import com.volcengine.tos.model.bucket.GetBucketMirrorBackInput;
import com.volcengine.tos.model.bucket.GetBucketMirrorBackOutput;
import com.volcengine.tos.model.bucket.GetBucketNotificationInput;
import com.volcengine.tos.model.bucket.GetBucketNotificationOutput;
import com.volcengine.tos.model.bucket.GetBucketPolicyInput;
import com.volcengine.tos.model.bucket.GetBucketPolicyOutput;
import com.volcengine.tos.model.bucket.GetBucketRealTimeLogInput;
import com.volcengine.tos.model.bucket.GetBucketRealTimeLogOutput;
import com.volcengine.tos.model.bucket.GetBucketRenameInput;
import com.volcengine.tos.model.bucket.GetBucketRenameOutput;
import com.volcengine.tos.model.bucket.GetBucketReplicationInput;
import com.volcengine.tos.model.bucket.GetBucketReplicationOutput;
import com.volcengine.tos.model.bucket.GetBucketVersioningInput;
import com.volcengine.tos.model.bucket.GetBucketVersioningOutput;
import com.volcengine.tos.model.bucket.GetBucketWebsiteInput;
import com.volcengine.tos.model.bucket.GetBucketWebsiteOutput;
import com.volcengine.tos.model.bucket.HeadBucketOutput;
import com.volcengine.tos.model.bucket.HeadBucketV2Input;
import com.volcengine.tos.model.bucket.HeadBucketV2Output;
import com.volcengine.tos.model.bucket.ListBucketCustomDomainInput;
import com.volcengine.tos.model.bucket.ListBucketCustomDomainOutput;
import com.volcengine.tos.model.bucket.ListBucketsInput;
import com.volcengine.tos.model.bucket.ListBucketsOutput;
import com.volcengine.tos.model.bucket.ListBucketsV2Input;
import com.volcengine.tos.model.bucket.ListBucketsV2Output;
import com.volcengine.tos.model.bucket.ListedBucket;
import com.volcengine.tos.model.bucket.ListedOwner;
import com.volcengine.tos.model.bucket.PutBucketACLInput;
import com.volcengine.tos.model.bucket.PutBucketACLOutput;
import com.volcengine.tos.model.bucket.PutBucketCORSInput;
import com.volcengine.tos.model.bucket.PutBucketCORSOutput;
import com.volcengine.tos.model.bucket.PutBucketCustomDomainInput;
import com.volcengine.tos.model.bucket.PutBucketCustomDomainOutput;
import com.volcengine.tos.model.bucket.PutBucketLifecycleInput;
import com.volcengine.tos.model.bucket.PutBucketLifecycleOutput;
import com.volcengine.tos.model.bucket.PutBucketMirrorBackInput;
import com.volcengine.tos.model.bucket.PutBucketMirrorBackOutput;
import com.volcengine.tos.model.bucket.PutBucketNotificationInput;
import com.volcengine.tos.model.bucket.PutBucketNotificationOutput;
import com.volcengine.tos.model.bucket.PutBucketPolicyInput;
import com.volcengine.tos.model.bucket.PutBucketPolicyOutput;
import com.volcengine.tos.model.bucket.PutBucketRealTimeLogInput;
import com.volcengine.tos.model.bucket.PutBucketRealTimeLogOutput;
import com.volcengine.tos.model.bucket.PutBucketRenameInput;
import com.volcengine.tos.model.bucket.PutBucketRenameOutput;
import com.volcengine.tos.model.bucket.PutBucketReplicationInput;
import com.volcengine.tos.model.bucket.PutBucketReplicationOutput;
import com.volcengine.tos.model.bucket.PutBucketStorageClassInput;
import com.volcengine.tos.model.bucket.PutBucketStorageClassOutput;
import com.volcengine.tos.model.bucket.PutBucketVersioningInput;
import com.volcengine.tos.model.bucket.PutBucketVersioningOutput;
import com.volcengine.tos.model.bucket.PutBucketWebsiteInput;
import com.volcengine.tos.model.bucket.PutBucketWebsiteOutput;
import com.volcengine.tos.model.object.AbortMultipartUploadInput;
import com.volcengine.tos.model.object.AbortMultipartUploadOutput;
import com.volcengine.tos.model.object.AppendObjectInput;
import com.volcengine.tos.model.object.AppendObjectOutput;
import com.volcengine.tos.model.object.CompleteMultipartUploadInput;
import com.volcengine.tos.model.object.CompleteMultipartUploadOutput;
import com.volcengine.tos.model.object.CompleteMultipartUploadV2Input;
import com.volcengine.tos.model.object.CompleteMultipartUploadV2Output;
import com.volcengine.tos.model.object.CopyEvent;
import com.volcengine.tos.model.object.CopyObjectOutput;
import com.volcengine.tos.model.object.CopyObjectV2Input;
import com.volcengine.tos.model.object.CopyObjectV2Output;
import com.volcengine.tos.model.object.CopyPartInfo;
import com.volcengine.tos.model.object.CopySourceObjectInfo;
import com.volcengine.tos.model.object.CreateMultipartUploadInput;
import com.volcengine.tos.model.object.CreateMultipartUploadOutput;
import com.volcengine.tos.model.object.DeleteError;
import com.volcengine.tos.model.object.DeleteMultiObjectsInput;
import com.volcengine.tos.model.object.DeleteMultiObjectsOutput;
import com.volcengine.tos.model.object.DeleteMultiObjectsV2Input;
import com.volcengine.tos.model.object.DeleteMultiObjectsV2Output;
import com.volcengine.tos.model.object.DeleteObjectInput;
import com.volcengine.tos.model.object.DeleteObjectOutput;
import com.volcengine.tos.model.object.DeleteObjectTaggingInput;
import com.volcengine.tos.model.object.DeleteObjectTaggingOutput;
import com.volcengine.tos.model.object.Deleted;
import com.volcengine.tos.model.object.FetchObjectInput;
import com.volcengine.tos.model.object.FetchObjectOutput;
import com.volcengine.tos.model.object.GetObjectACLV2Input;
import com.volcengine.tos.model.object.GetObjectACLV2Output;
import com.volcengine.tos.model.object.GetObjectBasicOutput;
import com.volcengine.tos.model.object.GetObjectOutput;
import com.volcengine.tos.model.object.GetObjectTaggingInput;
import com.volcengine.tos.model.object.GetObjectTaggingOutput;
import com.volcengine.tos.model.object.GetObjectToFileInput;
import com.volcengine.tos.model.object.GetObjectToFileOutput;
import com.volcengine.tos.model.object.GetObjectV2Input;
import com.volcengine.tos.model.object.GetObjectV2Output;
import com.volcengine.tos.model.object.HeadObjectOutput;
import com.volcengine.tos.model.object.HeadObjectV2Input;
import com.volcengine.tos.model.object.HeadObjectV2Output;
import com.volcengine.tos.model.object.InnerUploadedPart;
import com.volcengine.tos.model.object.ListMultipartUploadsInput;
import com.volcengine.tos.model.object.ListMultipartUploadsOutput;
import com.volcengine.tos.model.object.ListMultipartUploadsV2Input;
import com.volcengine.tos.model.object.ListMultipartUploadsV2Output;
import com.volcengine.tos.model.object.ListObjectVersionsInput;
import com.volcengine.tos.model.object.ListObjectVersionsOutput;
import com.volcengine.tos.model.object.ListObjectVersionsV2Input;
import com.volcengine.tos.model.object.ListObjectVersionsV2Output;
import com.volcengine.tos.model.object.ListObjectsInput;
import com.volcengine.tos.model.object.ListObjectsOutput;
import com.volcengine.tos.model.object.ListObjectsType2Input;
import com.volcengine.tos.model.object.ListObjectsType2Output;
import com.volcengine.tos.model.object.ListObjectsV2Input;
import com.volcengine.tos.model.object.ListObjectsV2Output;
import com.volcengine.tos.model.object.ListPartsInput;
import com.volcengine.tos.model.object.ListPartsOutput;
import com.volcengine.tos.model.object.ListUploadedPartsInput;
import com.volcengine.tos.model.object.ListUploadedPartsOutput;
import com.volcengine.tos.model.object.ListedCommonPrefix;
import com.volcengine.tos.model.object.ListedDeleteMarkerEntry;
import com.volcengine.tos.model.object.ListedObject;
import com.volcengine.tos.model.object.ListedObjectV2;
import com.volcengine.tos.model.object.ListedObjectVersion;
import com.volcengine.tos.model.object.ListedUpload;
import com.volcengine.tos.model.object.MultipartUploadedPart;
import com.volcengine.tos.model.object.ObjectAclRulesV2;
import com.volcengine.tos.model.object.ObjectMeta;
import com.volcengine.tos.model.object.ObjectMetaRequestOptions;
import com.volcengine.tos.model.object.PreSignedPolicyURLInput;
import com.volcengine.tos.model.object.PreSignedPolicyURLOutput;
import com.volcengine.tos.model.object.PreSignedURLInput;
import com.volcengine.tos.model.object.PreSignedURLOutput;
import com.volcengine.tos.model.object.PreSingedPolicyURLInput;
import com.volcengine.tos.model.object.PreSingedPolicyURLOutput;
import com.volcengine.tos.model.object.PutFetchTaskInput;
import com.volcengine.tos.model.object.PutFetchTaskOutput;
import com.volcengine.tos.model.object.PutObjectACLInput;
import com.volcengine.tos.model.object.PutObjectACLOutput;
import com.volcengine.tos.model.object.PutObjectFromFileInput;
import com.volcengine.tos.model.object.PutObjectFromFileOutput;
import com.volcengine.tos.model.object.PutObjectInput;
import com.volcengine.tos.model.object.PutObjectOutput;
import com.volcengine.tos.model.object.PutObjectTaggingInput;
import com.volcengine.tos.model.object.PutObjectTaggingOutput;
import com.volcengine.tos.model.object.RenameObjectInput;
import com.volcengine.tos.model.object.RenameObjectOutput;
import com.volcengine.tos.model.object.RestoreObjectInput;
import com.volcengine.tos.model.object.RestoreObjectOutput;
import com.volcengine.tos.model.object.ResumableCopyObjectCheckpoint;
import com.volcengine.tos.model.object.ResumableCopyObjectInput;
import com.volcengine.tos.model.object.ResumableCopyObjectOutput;
import com.volcengine.tos.model.object.SetObjectMetaInput;
import com.volcengine.tos.model.object.SetObjectMetaOutput;
import com.volcengine.tos.model.object.UploadCommonPrefix;
import com.volcengine.tos.model.object.UploadFileInput;
import com.volcengine.tos.model.object.UploadFileOutput;
import com.volcengine.tos.model.object.UploadFileV2Input;
import com.volcengine.tos.model.object.UploadFileV2Output;
import com.volcengine.tos.model.object.UploadInfo;
import com.volcengine.tos.model.object.UploadPartCopyInput;
import com.volcengine.tos.model.object.UploadPartCopyOutput;
import com.volcengine.tos.model.object.UploadPartCopyV2Input;
import com.volcengine.tos.model.object.UploadPartCopyV2Output;
import com.volcengine.tos.model.object.UploadPartFromFileInput;
import com.volcengine.tos.model.object.UploadPartFromFileOutput;
import com.volcengine.tos.model.object.UploadPartInput;
import com.volcengine.tos.model.object.UploadPartOutput;
import com.volcengine.tos.model.object.UploadPartV2Input;
import com.volcengine.tos.model.object.UploadPartV2Output;
import com.volcengine.tos.model.object.UploadedPart;
import com.volcengine.tos.model.object.UploadedPartV2;
import e7.C1424a;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CheckedInputStream;
import k2.C1621a;

/* loaded from: classes3.dex */
public final class c implements TOSV2 {

    /* renamed from: a, reason: collision with root package name */
    public b f1158a;
    public C1621a b;
    public C0234l c;
    public j d;
    public k e;
    public i f;
    public B1.b g;
    public K1.a h;
    public o i;

    public final void a() {
        if (AbstractC0291a.x(this.f1158a.b)) {
            if (!f.f().containsKey(this.f1158a.c)) {
                throw new TosClientException("endpoint is null and region is invalid", null);
            }
            this.f1158a.b = (String) ((List) f.f().get(this.f1158a.c)).get(0);
        }
    }

    @Override // com.volcengine.tos.TOSV2
    public final AbortMultipartUploadOutput abortMultipartUpload(AbortMultipartUploadInput abortMultipartUploadInput) {
        return this.c.a(abortMultipartUploadInput);
    }

    @Override // com.volcengine.tos.TOSV2
    public final AppendObjectOutput appendObject(AppendObjectInput appendObjectInput) {
        C0234l c0234l = this.c;
        c0234l.getClass();
        AbstractC0307c.a(appendObjectInput, "AppendObjectInput");
        if (c0234l.b && appendObjectInput.getOffset() > 0 && AbstractC0291a.x(appendObjectInput.getPreHashCrc64ecma())) {
            throw new TosClientException("tos: client enable crc64 check but preHashCrc64ecma is not set", null);
        }
        c0234l.k(appendObjectInput.getBucket());
        AbstractC0307c.c(appendObjectInput.getKey());
        if (appendObjectInput.getContentLength() <= 0) {
            throw new TosClientException("content length should be set in appendObject method.", null);
        }
        X6.c cVarC = ((o) c0234l.d).c(appendObjectInput.getBucket(), appendObjectInput.getKey(), appendObjectInput.getAllSettedHeaders());
        cVarC.d("append", "");
        cVarC.d(TypedValues.CycleType.S_WAVE_OFFSET, String.valueOf(appendObjectInput.getOffset()));
        cVarC.h = appendObjectInput.getContentLength();
        c0234l.b(cVarC, appendObjectInput.getKey());
        o oVar = (o) c0234l.d;
        InputStream content = appendObjectInput.getContent();
        oVar.getClass();
        n nVarA = o.a(cVarC, "POST", content);
        nVarA.h = false;
        nVarA.g = false;
        nVarA.i = c0234l.b;
        nVarA.f1518j = U7.a.Z(appendObjectInput.getPreHashCrc64ecma());
        appendObjectInput.getRateLimiter();
        appendObjectInput.getDataTransferListener();
        return (AppendObjectOutput) ((A0.b) c0234l.c).z(nVarA, 200, new X6.k(c0234l, 1));
    }

    @Override // com.volcengine.tos.TOSV2
    public final void changeCredentials(S6.b bVar) {
        b bVar2 = this.f1158a;
        bVar2.f1157a = bVar;
        if (bVar == null) {
            this.h = null;
        } else {
            this.h = new K1.a(bVar, bVar2.c);
        }
        o oVar = this.i;
        K1.a aVar = this.h;
        oVar.f1519a = aVar;
        this.b.b = oVar;
        C0234l c0234l = this.c;
        c0234l.d = oVar;
        this.d.b = c0234l;
        k kVar = this.e;
        kVar.c = aVar;
        kVar.b = oVar;
    }

    @Override // com.volcengine.tos.TOSV2
    public final void changeRegionAndEndpoint(String str, String str2) throws NumberFormatException, UnknownHostException {
        b bVar = this.f1158a;
        bVar.c = str;
        bVar.b = str2;
        a();
        this.i.d(str2);
        C1621a c1621a = this.b;
        o oVar = this.i;
        c1621a.b = oVar;
        C0234l c0234l = this.c;
        c0234l.d = oVar;
        this.d.b = c0234l;
        k kVar = this.e;
        kVar.c = this.h;
        kVar.b = oVar;
    }

    @Override // com.volcengine.tos.TOSV2
    public final void changeTransportConfig(C1424a c1424a) {
        this.f1158a.d = c1424a;
        B1.b bVar = this.g;
        bVar.getClass();
        c1424a.getClass();
        bVar.b = 3;
        C1621a c1621a = this.b;
        B1.b bVar2 = this.g;
        A0.b bVar3 = (A0.b) c1621a.f4793a;
        if (bVar3 == null) {
            c1621a.f4793a = new A0.b(bVar2, 3);
        } else {
            bVar3.b = bVar2;
        }
        C0234l c0234l = this.c;
        A0.b bVar4 = (A0.b) c0234l.c;
        if (bVar4 == null) {
            c0234l.c = new A0.b(bVar2, 3);
        } else {
            bVar4.b = bVar2;
        }
        j jVar = this.d;
        jVar.b = c0234l;
        A0.b bVar5 = jVar.f1514a;
        if (bVar5 == null) {
            jVar.f1514a = new A0.b(bVar2, 3);
        } else {
            bVar5.b = bVar2;
        }
    }

    @Override // com.volcengine.tos.TOSV2
    public final CompleteMultipartUploadV2Output completeMultipartUpload(CompleteMultipartUploadV2Input completeMultipartUploadV2Input) {
        return this.c.f(completeMultipartUploadV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final CopyObjectV2Output copyObject(CopyObjectV2Input copyObjectV2Input) {
        return this.c.g(copyObjectV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final CopyObjectOutput copyObjectFrom(String str, String str2, String str3, String str4, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        return iVar.a(new CopyObjectV2Input().setBucket(str).setKey(str4).setSrcKey(str3).setSrcBucket(str2), fVarArr);
    }

    @Override // com.volcengine.tos.TOSV2
    public final CopyObjectOutput copyObjectTo(String str, String str2, String str3, String str4, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        return iVar.a(new CopyObjectV2Input().setBucket(str2).setKey(str3).setSrcKey(str4).setSrcBucket(str), fVarArr);
    }

    @Override // com.volcengine.tos.TOSV2
    public final CreateBucketV2Output createBucket(String str) {
        return this.b.k(CreateBucketV2Input.builder().bucket(str).build());
    }

    @Override // com.volcengine.tos.TOSV2
    public final CreateMultipartUploadOutput createMultipartUpload(CreateMultipartUploadInput createMultipartUploadInput) {
        return this.c.h(createMultipartUploadInput);
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketOutput deleteBucket(String str) {
        return deleteBucket(DeleteBucketInput.builder().bucket(str).build());
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketCORSOutput deleteBucketCORS(DeleteBucketCORSInput deleteBucketCORSInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(deleteBucketCORSInput, "DeleteBucketCORSInput");
        c1621a.n(deleteBucketCORSInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(deleteBucketCORSInput.getBucket(), "", null);
        cVarC.d("cors", "");
        ((o) c1621a.b).getClass();
        return (DeleteBucketCORSOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "DELETE", null), ComposerKt.providerMapsKey, new G4.a(28));
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketCustomDomainOutput deleteBucketCustomDomain(DeleteBucketCustomDomainInput deleteBucketCustomDomainInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(deleteBucketCustomDomainInput, "DeleteBucketCustomDomainInput");
        AbstractC0307c.a(deleteBucketCustomDomainInput.getDomain(), "Domain");
        c1621a.n(deleteBucketCustomDomainInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(deleteBucketCustomDomainInput.getBucket(), "", null);
        cVarC.d("customdomain", deleteBucketCustomDomainInput.getDomain());
        ((o) c1621a.b).getClass();
        return (DeleteBucketCustomDomainOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "DELETE", null), 200, new G4.a(27));
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketLifecycleOutput deleteBucketLifecycle(DeleteBucketLifecycleInput deleteBucketLifecycleInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(deleteBucketLifecycleInput, "DeleteBucketLifecycleInput");
        c1621a.n(deleteBucketLifecycleInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(deleteBucketLifecycleInput.getBucket(), "", null);
        cVarC.d("lifecycle", "");
        ((o) c1621a.b).getClass();
        return (DeleteBucketLifecycleOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "DELETE", null), ComposerKt.providerMapsKey, new G4.a(10));
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketMirrorBackOutput deleteBucketMirrorBack(DeleteBucketMirrorBackInput deleteBucketMirrorBackInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(deleteBucketMirrorBackInput, "DeleteBucketMirrorBackInput");
        c1621a.n(deleteBucketMirrorBackInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(deleteBucketMirrorBackInput.getBucket(), "", null);
        cVarC.d("mirror", "");
        ((o) c1621a.b).getClass();
        return (DeleteBucketMirrorBackOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "DELETE", null), ComposerKt.providerMapsKey, new G4.a(14));
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketPolicyOutput deleteBucketPolicy(String str) {
        return deleteBucketPolicy(DeleteBucketPolicyInput.builder().bucket(str).build());
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketRealTimeLogOutput deleteBucketRealTimeLog(DeleteBucketRealTimeLogInput deleteBucketRealTimeLogInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(deleteBucketRealTimeLogInput, "DeleteBucketRealTimeLogInput");
        c1621a.n(deleteBucketRealTimeLogInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(deleteBucketRealTimeLogInput.getBucket(), "", null);
        cVarC.d("realtimeLog", "");
        ((o) c1621a.b).getClass();
        return (DeleteBucketRealTimeLogOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "DELETE", null), ComposerKt.providerMapsKey, new G4.a(20));
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketRenameOutput deleteBucketRename(DeleteBucketRenameInput deleteBucketRenameInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(deleteBucketRenameInput, "DeleteBucketRenameInput");
        c1621a.n(deleteBucketRenameInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(deleteBucketRenameInput.getBucket(), "", null);
        cVarC.d("rename", "");
        ((o) c1621a.b).getClass();
        return (DeleteBucketRenameOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "DELETE", null), ComposerKt.providerMapsKey, new G4.a(8));
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketReplicationOutput deleteBucketReplication(DeleteBucketReplicationInput deleteBucketReplicationInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(deleteBucketReplicationInput, "DeleteBucketReplicationInput");
        c1621a.n(deleteBucketReplicationInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(deleteBucketReplicationInput.getBucket(), "", null);
        cVarC.d("replication", "");
        ((o) c1621a.b).getClass();
        return (DeleteBucketReplicationOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "DELETE", null), ComposerKt.providerMapsKey, new G4.a(15));
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketWebsiteOutput deleteBucketWebsite(DeleteBucketWebsiteInput deleteBucketWebsiteInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(deleteBucketWebsiteInput, "DeleteBucketWebsiteInput");
        c1621a.n(deleteBucketWebsiteInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(deleteBucketWebsiteInput.getBucket(), "", null);
        cVarC.d("website", "");
        ((o) c1621a.b).getClass();
        return (DeleteBucketWebsiteOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "DELETE", null), ComposerKt.providerMapsKey, new h(0));
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteMultiObjectsV2Output deleteMultiObjects(DeleteMultiObjectsV2Input deleteMultiObjectsV2Input) {
        return this.c.i(deleteMultiObjectsV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteObjectOutput deleteObject(DeleteObjectInput deleteObjectInput) {
        return this.c.j(deleteObjectInput);
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteObjectTaggingOutput deleteObjectTagging(DeleteObjectTaggingInput deleteObjectTaggingInput) {
        C0234l c0234l = this.c;
        c0234l.getClass();
        AbstractC0307c.a(deleteObjectTaggingInput, "DeleteObjectTaggingInput");
        c0234l.k(deleteObjectTaggingInput.getBucket());
        AbstractC0307c.c(deleteObjectTaggingInput.getKey());
        X6.c cVarC = ((o) c0234l.d).c(deleteObjectTaggingInput.getBucket(), deleteObjectTaggingInput.getKey(), null);
        cVarC.d("tagging", "");
        ((o) c0234l.d).getClass();
        return (DeleteObjectTaggingOutput) ((A0.b) c0234l.c).z(o.a(cVarC, "DELETE", null), ComposerKt.providerMapsKey, new h(3));
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x0339 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x031e A[EDGE_INSN: B:190:0x031e->B:85:0x031e BREAK  A[LOOP:4: B:82:0x02fd->B:84:0x0302], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01db A[Catch: IOException -> 0x01e3, TryCatch #0 {IOException -> 0x01e3, blocks: (B:47:0x01d5, B:49:0x01db, B:53:0x01f0, B:52:0x01e6), top: B:171:0x01d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e6 A[Catch: IOException -> 0x01e3, TryCatch #0 {IOException -> 0x01e3, blocks: (B:47:0x01d5, B:49:0x01db, B:53:0x01f0, B:52:0x01e6), top: B:171:0x01d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0302 A[LOOP:4: B:82:0x02fd->B:84:0x0302, LOOP_END] */
    @Override // com.volcengine.tos.TOSV2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.volcengine.tos.model.object.DownloadFileOutput downloadFile(com.volcengine.tos.model.object.DownloadFileInput r23) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R6.c.downloadFile(com.volcengine.tos.model.object.DownloadFileInput):com.volcengine.tos.model.object.DownloadFileOutput");
    }

    @Override // com.volcengine.tos.TOSV2
    public final FetchObjectOutput fetchObject(FetchObjectInput fetchObjectInput) {
        C0234l c0234l = this.c;
        c0234l.getClass();
        AbstractC0307c.a(fetchObjectInput, "FetchObjectInput");
        c0234l.k(fetchObjectInput.getBucket());
        AbstractC0307c.c(fetchObjectInput.getKey());
        AbstractC0307c.a(fetchObjectInput.getUrl(), "URL");
        g gVarC = AbstractC0308d.c(fetchObjectInput);
        X6.c cVarC = ((o) c0234l.d).c(fetchObjectInput.getBucket(), fetchObjectInput.getKey(), fetchObjectInput.getAllSettedHeaders());
        cVarC.d("fetch", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c0234l.d;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "POST", byteArrayInputStream);
        nVarA.f = r0.length;
        return (FetchObjectOutput) ((A0.b) c0234l.c).z(nVarA, 200, new X6.k(c0234l, 10));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketACLOutput getBucketACL(GetBucketACLInput getBucketACLInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketACLInput, "GetBucketACLInput");
        c1621a.n(getBucketACLInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketACLInput.getBucket(), "", null);
        cVarC.d("acl", "");
        ((o) c1621a.b).getClass();
        return (GetBucketACLOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 4));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketCORSOutput getBucketCORS(GetBucketCORSInput getBucketCORSInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketCORSInput, "GetBucketCORSInput");
        c1621a.n(getBucketCORSInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketCORSInput.getBucket(), "", null);
        cVarC.d("cors", "");
        ((o) c1621a.b).getClass();
        return (GetBucketCORSOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 1));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketLifecycleOutput getBucketLifecycle(GetBucketLifecycleInput getBucketLifecycleInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketLifecycleInput, "GetBucketLifecycleInput");
        c1621a.n(getBucketLifecycleInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketLifecycleInput.getBucket(), "", null);
        cVarC.d("lifecycle", "");
        ((o) c1621a.b).getClass();
        return (GetBucketLifecycleOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 11));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketLocationOutput getBucketLocation(GetBucketLocationInput getBucketLocationInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketLocationInput, "GetBucketLocationInput");
        c1621a.n(getBucketLocationInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketLocationInput.getBucket(), "", null);
        cVarC.d("location", "");
        ((o) c1621a.b).getClass();
        return (GetBucketLocationOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 7));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketMirrorBackOutput getBucketMirrorBack(GetBucketMirrorBackInput getBucketMirrorBackInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketMirrorBackInput, "GetBucketMirrorBackInput");
        c1621a.n(getBucketMirrorBackInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketMirrorBackInput.getBucket(), "", null);
        cVarC.d("mirror", "");
        ((o) c1621a.b).getClass();
        return (GetBucketMirrorBackOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 0));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketNotificationOutput getBucketNotification(GetBucketNotificationInput getBucketNotificationInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketNotificationInput, "GetBucketNotificationInput");
        c1621a.n(getBucketNotificationInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketNotificationInput.getBucket(), "", null);
        cVarC.d("notification", "");
        ((o) c1621a.b).getClass();
        return (GetBucketNotificationOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 10));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketPolicyOutput getBucketPolicy(String str) {
        return getBucketPolicy(GetBucketPolicyInput.builder().bucket(str).build());
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketRealTimeLogOutput getBucketRealTimeLog(GetBucketRealTimeLogInput getBucketRealTimeLogInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketRealTimeLogInput, "GetBucketRealTimeLogInput");
        c1621a.n(getBucketRealTimeLogInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketRealTimeLogInput.getBucket(), "", null);
        cVarC.d("realtimeLog", "");
        ((o) c1621a.b).getClass();
        return (GetBucketRealTimeLogOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 8));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketRenameOutput getBucketRename(GetBucketRenameInput getBucketRenameInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketRenameInput, "GetBucketRenameInput");
        c1621a.n(getBucketRenameInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketRenameInput.getBucket(), "", null);
        cVarC.d("rename", "");
        ((o) c1621a.b).getClass();
        return (GetBucketRenameOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 6));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketReplicationOutput getBucketReplication(GetBucketReplicationInput getBucketReplicationInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketReplicationInput, "GetBucketReplicationInput");
        c1621a.n(getBucketReplicationInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketReplicationInput.getBucket(), "", null);
        cVarC.d("replication", "");
        cVarC.d("progress", "");
        cVarC.d("rule-id", getBucketReplicationInput.getRuleID());
        ((o) c1621a.b).getClass();
        return (GetBucketReplicationOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 2));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketVersioningOutput getBucketVersioning(GetBucketVersioningInput getBucketVersioningInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketVersioningInput, "GetBucketVersioningInput");
        c1621a.n(getBucketVersioningInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketVersioningInput.getBucket(), "", null);
        cVarC.d("versioning", "");
        ((o) c1621a.b).getClass();
        return (GetBucketVersioningOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 9));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketWebsiteOutput getBucketWebsite(GetBucketWebsiteInput getBucketWebsiteInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketWebsiteInput, "GetBucketWebsiteInput");
        c1621a.n(getBucketWebsiteInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketWebsiteInput.getBucket(), "", null);
        cVarC.d("website", "");
        ((o) c1621a.b).getClass();
        return (GetBucketWebsiteOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 5));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetObjectV2Output getObject(GetObjectV2Input getObjectV2Input) {
        return this.c.m(getObjectV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetObjectACLV2Output getObjectAcl(GetObjectACLV2Input getObjectACLV2Input) {
        return this.c.n(getObjectACLV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetObjectTaggingOutput getObjectTagging(GetObjectTaggingInput getObjectTaggingInput) {
        C0234l c0234l = this.c;
        c0234l.getClass();
        AbstractC0307c.a(getObjectTaggingInput, "GetObjectTaggingInput");
        c0234l.k(getObjectTaggingInput.getBucket());
        AbstractC0307c.c(getObjectTaggingInput.getKey());
        X6.c cVarC = ((o) c0234l.d).c(getObjectTaggingInput.getBucket(), getObjectTaggingInput.getKey(), null);
        cVarC.d("tagging", "");
        cVarC.d("versionId", getObjectTaggingInput.getVersionID());
        ((o) c0234l.d).getClass();
        return (GetObjectTaggingOutput) ((A0.b) c0234l.c).z(o.a(cVarC, "GET", null), 200, new X6.k(c0234l, 9));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetObjectToFileOutput getObjectToFile(GetObjectToFileInput getObjectToFileInput) {
        j jVar = this.d;
        jVar.getClass();
        AbstractC0307c.a(getObjectToFileInput, "GetObjectToFileInput");
        try {
            GetObjectV2Output getObjectV2OutputM = jVar.b.m(getObjectToFileInput.getGetObjectInputV2());
            try {
                String filePath = getObjectToFileInput.getFilePath();
                if (AbstractC0291a.x(filePath)) {
                    File file = getObjectToFileInput.getFile();
                    if (file == null) {
                        throw new TosClientException("tos: file path is null", null);
                    }
                    filePath = file.getPath();
                }
                String strJ = Z6.k.J(filePath, getObjectToFileInput.getKey());
                if (AbstractC0291a.x(strJ)) {
                    if (getObjectV2OutputM != null) {
                        getObjectV2OutputM.close();
                    }
                    return null;
                }
                File file2 = new File(strJ);
                File file3 = new File(strJ + ".temp");
                if (getObjectV2OutputM.getContent() != null) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file3);
                        try {
                            InputStream checkedInputStream = jVar.c ? new CheckedInputStream(getObjectV2OutputM.getContent(), new Y6.a()) : getObjectV2OutputM.getContent();
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i = checkedInputStream.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                checkedInputStream.close();
                                fileOutputStream.close();
                            } finally {
                            }
                        } finally {
                        }
                    } catch (IOException e) {
                        throw new TosClientException("tos: write data to local file failed", e);
                    }
                } else {
                    try {
                        file3.createNewFile();
                    } catch (IOException e6) {
                        throw new TosClientException("tos: create new local file failed", e6);
                    }
                }
                if (file3.renameTo(file2)) {
                    GetObjectToFileOutput getObjectToFileOutput = new GetObjectToFileOutput(getObjectV2OutputM.getGetObjectBasicOutput());
                    getObjectV2OutputM.close();
                    return getObjectToFileOutput;
                }
                throw new TosClientException("tos: move temp file to dst file failed, src: " + file3.getPath() + ", dst: " + file2.getPath(), null);
            } finally {
            }
        } catch (IOException e9) {
            throw new TosClientException("tos: close content failed.", e9);
        }
    }

    @Override // com.volcengine.tos.TOSV2
    public final HeadBucketV2Output headBucket(HeadBucketV2Input headBucketV2Input) {
        return this.b.r(headBucketV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final HeadObjectV2Output headObject(HeadObjectV2Input headObjectV2Input) {
        return this.c.o(headObjectV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListBucketCustomDomainOutput listBucketCustomDomain(ListBucketCustomDomainInput listBucketCustomDomainInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(listBucketCustomDomainInput, "ListBucketCustomDomainInput");
        c1621a.n(listBucketCustomDomainInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(listBucketCustomDomainInput.getBucket(), "", null);
        cVarC.d("customdomain", "");
        ((o) c1621a.b).getClass();
        return (ListBucketCustomDomainOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new X6.g(c1621a, 3));
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListBucketsV2Output listBuckets(ListBucketsV2Input listBucketsV2Input) {
        return this.b.u(listBucketsV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListMultipartUploadsV2Output listMultipartUploads(ListMultipartUploadsV2Input listMultipartUploadsV2Input) {
        return this.c.p(listMultipartUploadsV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListObjectVersionsV2Output listObjectVersions(ListObjectVersionsV2Input listObjectVersionsV2Input) {
        return this.c.q(listObjectVersionsV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListObjectsV2Output listObjects(ListObjectsV2Input listObjectsV2Input) {
        return this.c.r(listObjectsV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListObjectsType2Output listObjectsType2(ListObjectsType2Input listObjectsType2Input) {
        AbstractC0307c.a(listObjectsType2Input, "ListObjectsType2Input");
        if (listObjectsType2Input.isListOnlyOnce()) {
            return this.c.s(listObjectsType2Input);
        }
        C0234l c0234l = this.c;
        c0234l.getClass();
        AbstractC0307c.a(listObjectsType2Input, "ListObjectsType2Input");
        if (listObjectsType2Input.isListOnlyOnce()) {
            return c0234l.s(listObjectsType2Input);
        }
        int maxKeys = listObjectsType2Input.getMaxKeys() > 0 ? listObjectsType2Input.getMaxKeys() : 1000;
        String continuationToken = listObjectsType2Input.getContinuationToken();
        ListObjectsType2Output listObjectsType2OutputS = null;
        List<ListedCommonPrefix> commonPrefixes = null;
        List<ListedObjectV2> contents = null;
        boolean z10 = false;
        int keyCount = 0;
        while (!z10) {
            listObjectsType2OutputS = c0234l.s(listObjectsType2Input.setContinuationToken(continuationToken));
            if (listObjectsType2OutputS.getCommonPrefixes() != null) {
                if (commonPrefixes == null) {
                    commonPrefixes = listObjectsType2OutputS.getCommonPrefixes();
                } else {
                    commonPrefixes.addAll(listObjectsType2OutputS.getCommonPrefixes());
                }
            }
            if (listObjectsType2OutputS.getContents() != null) {
                if (contents == null) {
                    contents = listObjectsType2OutputS.getContents();
                } else {
                    contents.addAll(listObjectsType2OutputS.getContents());
                }
            }
            keyCount += listObjectsType2OutputS.getKeyCount();
            continuationToken = listObjectsType2OutputS.getNextContinuationToken();
            z10 = maxKeys == keyCount || !listObjectsType2OutputS.isTruncated();
        }
        return listObjectsType2OutputS.setCommonPrefixes(commonPrefixes).setContents(contents).setKeyCount(keyCount);
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListPartsOutput listParts(ListPartsInput listPartsInput) {
        return this.c.t(listPartsInput);
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListUploadedPartsOutput listUploadedParts(String str, ListUploadedPartsInput listUploadedPartsInput, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(listUploadedPartsInput, "ListUploadedPartsInput");
        ListPartsOutput listPartsOutputT = iVar.b.t(new ListPartsInput().setBucket(str).setKey(listUploadedPartsInput.getKey()).setMaxParts(listUploadedPartsInput.getMaxParts()).setUploadID(listUploadedPartsInput.getUploadID()).setPartNumberMarker(listUploadedPartsInput.getPartNumberMarker()));
        ListUploadedPartsOutput uploadID = new ListUploadedPartsOutput().setRequestInfo(listPartsOutputT.getRequestInfo()).setBucket(listPartsOutputT.getBucket()).setKey(listPartsOutputT.getKey()).setMaxParts(listPartsOutputT.getMaxParts()).setPartNumberMarker(listPartsOutputT.getPartNumberMarker()).setOwner(listPartsOutputT.getOwner()).setNextPartNumberMarker(listPartsOutputT.getNextPartNumberMarker()).setStorageClass(listPartsOutputT.getStorageClass() == null ? null : listPartsOutputT.getStorageClass().f4230a).setTruncated(listPartsOutputT.isTruncated()).setUploadID(listPartsOutputT.getUploadID());
        if (listPartsOutputT.getUploadedParts() != null) {
            UploadedPart[] uploadedPartArr = new UploadedPart[listPartsOutputT.getUploadedParts().size()];
            for (int i = 0; i < listPartsOutputT.getUploadedParts().size(); i++) {
                UploadedPartV2 uploadedPartV2 = listPartsOutputT.getUploadedParts().get(i);
                uploadedPartArr[i] = new UploadedPart().setPartNumber(uploadedPartV2.getPartNumber()).setEtag(uploadedPartV2.getEtag()).setSize(uploadedPartV2.getSize()).setLastModified(AbstractC0306b.a(uploadedPartV2.getLastModified()));
            }
            uploadID.setUploadedParts(uploadedPartArr);
        }
        return uploadID;
    }

    @Override // com.volcengine.tos.TOSV2
    public final PreSignedPolicyURLOutput preSignedPolicyURL(PreSignedPolicyURLInput preSignedPolicyURLInput) {
        return this.e.o(preSignedPolicyURLInput);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a6  */
    @Override // com.volcengine.tos.TOSV2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.volcengine.tos.model.object.PreSignedPostSignatureOutput preSignedPostSignature(com.volcengine.tos.model.object.PreSignedPostSignatureInput r17) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R6.c.preSignedPostSignature(com.volcengine.tos.model.object.PreSignedPostSignatureInput):com.volcengine.tos.model.object.PreSignedPostSignatureOutput");
    }

    @Override // com.volcengine.tos.TOSV2
    public final PreSignedURLOutput preSignedURL(PreSignedURLInput preSignedURLInput) {
        return this.e.p(preSignedURLInput);
    }

    @Override // com.volcengine.tos.TOSV2
    public final PreSingedPolicyURLOutput preSingedPolicyURL(PreSingedPolicyURLInput preSingedPolicyURLInput) {
        AbstractC0307c.a(preSingedPolicyURLInput, "PreSingedPolicyURLInput");
        PreSignedPolicyURLOutput preSignedPolicyURLOutputO = this.e.o(new PreSignedPolicyURLInput().setBucket(preSingedPolicyURLInput.getBucket()).setExpires(preSingedPolicyURLInput.getExpires()).setConditions(preSingedPolicyURLInput.getConditions()).setAlternativeEndpoint(preSingedPolicyURLInput.getAlternativeEndpoint()).setCustomDomain(preSingedPolicyURLInput.isCustomDomain()));
        return new PreSingedPolicyURLOutput().setPreSignedPolicyURLGenerator(preSignedPolicyURLOutputO.getPreSignedPolicyURLGenerator()).setSignatureQuery(preSignedPolicyURLOutputO.getSignatureQuery()).setHost(preSignedPolicyURLOutputO.getHost()).setScheme(preSignedPolicyURLOutputO.getScheme());
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketACLOutput putBucketACL(PutBucketACLInput putBucketACLInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketACLInput, "PutBucketACLInput");
        c1621a.n(putBucketACLInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(putBucketACLInput.getBucket(), "", null);
        cVarC.d("acl", "");
        cVarC.c("X-Tos-Acl", putBucketACLInput.getAcl() != null ? putBucketACLInput.getAcl().f4219a : null);
        cVarC.c("X-Tos-Grant-Full-Control", putBucketACLInput.getGrantFullControl());
        cVarC.c("X-Tos-Grant-Read", putBucketACLInput.getGrantRead());
        cVarC.c("X-Tos-Grant-Read-Acp", putBucketACLInput.getGrantReadAcp());
        cVarC.c("X-Tos-Grant-Write", putBucketACLInput.getGrantWrite());
        cVarC.c("X-Tos-Grant-Write-Acp", putBucketACLInput.getGrantWriteAcp());
        byte[] bArr = new byte[0];
        if (putBucketACLInput.getOwner() != null && AbstractC0291a.y(putBucketACLInput.getOwner().getId()) && putBucketACLInput.getGrants() != null && putBucketACLInput.getGrants().size() > 0) {
            g gVarC = AbstractC0308d.c(putBucketACLInput);
            bArr = (byte[]) gVarC.c;
            cVarC.c("Content-MD5", (String) gVarC.b);
        }
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = bArr.length;
        return (PutBucketACLOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new G4.a(17));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketCORSOutput putBucketCORS(PutBucketCORSInput putBucketCORSInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketCORSInput, "PutBucketCORSInput");
        AbstractC0307c.a(putBucketCORSInput.getRules(), "CORSRules");
        c1621a.n(putBucketCORSInput.getBucket());
        g gVarC = AbstractC0308d.c(putBucketCORSInput);
        X6.c cVarC = ((o) c1621a.b).c(putBucketCORSInput.getBucket(), "", null);
        cVarC.d("cors", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutBucketCORSOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new G4.a(7));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketCustomDomainOutput putBucketCustomDomain(PutBucketCustomDomainInput putBucketCustomDomainInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketCustomDomainInput, "PutBucketCustomDomainInput");
        c1621a.n(putBucketCustomDomainInput.getBucket());
        g gVarC = AbstractC0308d.c(putBucketCustomDomainInput);
        X6.c cVarC = ((o) c1621a.b).c(putBucketCustomDomainInput.getBucket(), "", null);
        cVarC.d("customdomain", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutBucketCustomDomainOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new G4.a(19));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketLifecycleOutput putBucketLifecycle(PutBucketLifecycleInput putBucketLifecycleInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketLifecycleInput, "PutBucketLifecycleInput");
        AbstractC0307c.a(putBucketLifecycleInput.getRules(), "LifecycleRules");
        c1621a.n(putBucketLifecycleInput.getBucket());
        g gVarC = AbstractC0308d.c(putBucketLifecycleInput);
        X6.c cVarC = ((o) c1621a.b).c(putBucketLifecycleInput.getBucket(), "", null);
        cVarC.d("lifecycle", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutBucketLifecycleOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new G4.a(22));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketMirrorBackOutput putBucketMirrorBack(PutBucketMirrorBackInput putBucketMirrorBackInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketMirrorBackInput, "PutBucketMirrorBackInput");
        AbstractC0307c.a(putBucketMirrorBackInput.getRules(), "MirrorBackRules");
        c1621a.n(putBucketMirrorBackInput.getBucket());
        g gVarC = AbstractC0308d.c(putBucketMirrorBackInput);
        X6.c cVarC = ((o) c1621a.b).c(putBucketMirrorBackInput.getBucket(), "", null);
        cVarC.d("mirror", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutBucketMirrorBackOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new G4.a(24));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketNotificationOutput putBucketNotification(PutBucketNotificationInput putBucketNotificationInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketNotificationInput, "PutBucketNotificationInput");
        c1621a.n(putBucketNotificationInput.getBucket());
        g gVarC = AbstractC0308d.c(putBucketNotificationInput);
        X6.c cVarC = ((o) c1621a.b).c(putBucketNotificationInput.getBucket(), "", null);
        cVarC.d("notification", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutBucketNotificationOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new G4.a(21));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketPolicyOutput putBucketPolicy(String str, String str2) {
        return putBucketPolicy(PutBucketPolicyInput.builder().bucket(str).policy(str2).build());
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketRealTimeLogOutput putBucketRealTimeLog(PutBucketRealTimeLogInput putBucketRealTimeLogInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketRealTimeLogInput, "PutBucketRealTimeLogInput");
        c1621a.n(putBucketRealTimeLogInput.getBucket());
        g gVarC = AbstractC0308d.c(putBucketRealTimeLogInput);
        X6.c cVarC = ((o) c1621a.b).c(putBucketRealTimeLogInput.getBucket(), "", null);
        cVarC.d("realtimeLog", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutBucketRealTimeLogOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new h(1));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketRenameOutput putBucketRename(PutBucketRenameInput putBucketRenameInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketRenameInput, "PutBucketRenameInput");
        c1621a.n(putBucketRenameInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(putBucketRenameInput.getBucket(), "", null);
        cVarC.d("rename", "");
        g gVarC = AbstractC0308d.c(putBucketRenameInput);
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r5.length;
        return (PutBucketRenameOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new G4.a(6));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketReplicationOutput putBucketReplication(PutBucketReplicationInput putBucketReplicationInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketReplicationInput, "PutBucketReplicationInput");
        AbstractC0307c.a(putBucketReplicationInput.getRole(), "ReplicationRole");
        AbstractC0307c.a(putBucketReplicationInput.getRules(), "ReplicationRule");
        c1621a.n(putBucketReplicationInput.getBucket());
        g gVarC = AbstractC0308d.c(putBucketReplicationInput);
        X6.c cVarC = ((o) c1621a.b).c(putBucketReplicationInput.getBucket(), "", null);
        cVarC.d("replication", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutBucketReplicationOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new G4.a(18));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketStorageClassOutput putBucketStorageClass(PutBucketStorageClassInput putBucketStorageClassInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketStorageClassInput, "PutBucketStorageClassInput");
        AbstractC0307c.a(putBucketStorageClassInput.getStorageClass(), "StorageClass");
        c1621a.n(putBucketStorageClassInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(putBucketStorageClassInput.getBucket(), "", null);
        cVarC.d("storageClass", "");
        cVarC.c("X-Tos-Storage-Class", putBucketStorageClassInput.getStorageClass().f4230a);
        ((o) c1621a.b).getClass();
        return (PutBucketStorageClassOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "PUT", null), 200, new G4.a(23));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketVersioningOutput putBucketVersioning(PutBucketVersioningInput putBucketVersioningInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketVersioningInput, "PutBucketVersioningInput");
        AbstractC0307c.a(putBucketVersioningInput.getStatus(), "VersioningStatusType");
        c1621a.n(putBucketVersioningInput.getBucket());
        g gVarC = AbstractC0308d.c(putBucketVersioningInput);
        X6.c cVarC = ((o) c1621a.b).c(putBucketVersioningInput.getBucket(), "", null);
        cVarC.d("versioning", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutBucketVersioningOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new G4.a(12));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketWebsiteOutput putBucketWebsite(PutBucketWebsiteInput putBucketWebsiteInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketWebsiteInput, "PutBucketWebsiteInput");
        c1621a.n(putBucketWebsiteInput.getBucket());
        g gVarC = AbstractC0308d.c(putBucketWebsiteInput);
        X6.c cVarC = ((o) c1621a.b).c(putBucketWebsiteInput.getBucket(), "", null);
        cVarC.d("website", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutBucketWebsiteOutput) ((A0.b) c1621a.f4793a).z(nVarA, 200, new G4.a(9));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutFetchTaskOutput putFetchTask(PutFetchTaskInput putFetchTaskInput) {
        C0234l c0234l = this.c;
        c0234l.getClass();
        AbstractC0307c.a(putFetchTaskInput, "PutFetchTaskInput");
        c0234l.k(putFetchTaskInput.getBucket());
        AbstractC0307c.c(putFetchTaskInput.getKey());
        AbstractC0307c.a(putFetchTaskInput.getUrl(), "URL");
        g gVarC = AbstractC0308d.c(putFetchTaskInput);
        X6.c cVarC = ((o) c0234l.d).c(putFetchTaskInput.getBucket(), "", putFetchTaskInput.getAllSettedHeaders());
        cVarC.d("fetchTask", "");
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c0234l.d;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "POST", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutFetchTaskOutput) ((A0.b) c0234l.c).z(nVarA, 200, new X6.k(c0234l, 6));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutObjectOutput putObject(PutObjectInput putObjectInput) {
        return this.c.u(putObjectInput);
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutObjectACLOutput putObjectAcl(PutObjectACLInput putObjectACLInput) {
        return this.c.v(putObjectACLInput);
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutObjectFromFileOutput putObjectFromFile(PutObjectFromFileInput putObjectFromFileInput) {
        V6.b bVar;
        V6.b bVar2;
        j jVar = this.d;
        jVar.getClass();
        AbstractC0307c.a(putObjectFromFileInput, "PutObjectFromFileInput");
        FileInputStream fileInputStream = putObjectFromFileInput.getFileInputStream();
        File file = putObjectFromFileInput.getFile();
        String filePath = putObjectFromFileInput.getFilePath();
        if (fileInputStream != null) {
            bVar2 = new V6.b(fileInputStream, 0);
        } else {
            if (file != null) {
                try {
                    bVar = new V6.b(new FileInputStream(file), 0);
                } catch (IOException e) {
                    throw new TosClientException("getFileContent failed.", e);
                }
            } else {
                if (filePath == null) {
                    throw new TosClientException("file info is not set in the input, please set filepath at least", null);
                }
                try {
                    bVar = new V6.b(new FileInputStream(filePath), 0);
                } catch (IOException e6) {
                    throw new TosClientException("getFileContent failed.", e6);
                }
            }
            bVar2 = bVar;
        }
        C0234l c0234l = jVar.b;
        PutObjectInput.PutObjectInputBuilder putObjectInputBuilderOptions = PutObjectInput.builder().bucket(putObjectFromFileInput.getBucket()).key(putObjectFromFileInput.getKey()).options(putObjectFromFileInput.getOptions());
        putObjectFromFileInput.getDataTransferListener();
        PutObjectInput.PutObjectInputBuilder putObjectInputBuilderDataTransferListener = putObjectInputBuilderOptions.dataTransferListener(null);
        putObjectFromFileInput.getRateLimiter();
        PutObjectInput.PutObjectInputBuilder putObjectInputBuilderRateLimiter = putObjectInputBuilderDataTransferListener.rateLimiter(null);
        File file2 = putObjectFromFileInput.getFile();
        String filePath2 = putObjectFromFileInput.getFilePath();
        return new PutObjectFromFileOutput(c0234l.u(putObjectInputBuilderRateLimiter.contentLength(file2 != null ? file2.length() : AbstractC0291a.y(filePath2) ? new File(filePath2).length() : -1L).content(bVar2).build()));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutObjectTaggingOutput putObjectTagging(PutObjectTaggingInput putObjectTaggingInput) {
        C0234l c0234l = this.c;
        c0234l.getClass();
        AbstractC0307c.a(putObjectTaggingInput, "PutObjectTaggingInput");
        AbstractC0307c.a(putObjectTaggingInput.getTagSet(), "TagSet");
        c0234l.k(putObjectTaggingInput.getBucket());
        AbstractC0307c.c(putObjectTaggingInput.getKey());
        g gVarC = AbstractC0308d.c(putObjectTaggingInput);
        X6.c cVarC = ((o) c0234l.d).c(putObjectTaggingInput.getBucket(), putObjectTaggingInput.getKey(), null);
        cVarC.d("tagging", "");
        cVarC.d("versionId", putObjectTaggingInput.getVersionID());
        cVarC.c("Content-MD5", (String) gVarC.b);
        o oVar = (o) c0234l.d;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = r0.length;
        return (PutObjectTaggingOutput) ((A0.b) c0234l.c).z(nVarA, 200, new h(9));
    }

    @Override // com.volcengine.tos.TOSV2
    public final RenameObjectOutput renameObject(RenameObjectInput renameObjectInput) {
        C0234l c0234l = this.c;
        c0234l.getClass();
        AbstractC0307c.a(renameObjectInput, "RenameObjectInput");
        c0234l.k(renameObjectInput.getBucket());
        AbstractC0307c.c(renameObjectInput.getKey());
        AbstractC0307c.c(renameObjectInput.getNewKey());
        X6.c cVarC = ((o) c0234l.d).c(renameObjectInput.getBucket(), renameObjectInput.getKey(), null);
        cVarC.d(HintConstants.AUTOFILL_HINT_NAME, renameObjectInput.getNewKey());
        cVarC.d("rename", "");
        ((o) c0234l.d).getClass();
        return (RenameObjectOutput) ((A0.b) c0234l.c).z(o.a(cVarC, "PUT", null), ComposerKt.providerMapsKey, new h(4));
    }

    @Override // com.volcengine.tos.TOSV2
    public final RestoreObjectOutput restoreObject(RestoreObjectInput restoreObjectInput) {
        C0234l c0234l = this.c;
        c0234l.getClass();
        AbstractC0307c.a(restoreObjectInput, "RestoreObjectInput");
        c0234l.k(restoreObjectInput.getBucket());
        AbstractC0307c.c(restoreObjectInput.getKey());
        g gVarC = AbstractC0308d.c(restoreObjectInput);
        X6.c cVarC = ((o) c0234l.d).c(restoreObjectInput.getBucket(), restoreObjectInput.getKey(), null);
        cVarC.c("Content-MD5", (String) gVarC.b);
        cVarC.d("restore", "");
        cVarC.d("versionId", restoreObjectInput.getVersionID());
        o oVar = (o) c0234l.d;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) gVarC.c);
        oVar.getClass();
        n nVarA = o.a(cVarC, "POST", byteArrayInputStream);
        nVarA.f = r0.length;
        A0.b bVar = (A0.b) c0234l.c;
        ArrayList arrayList = new ArrayList();
        arrayList.add(200);
        arrayList.add(Integer.valueOf(ComposerKt.compositionLocalMapKey));
        bVar.getClass();
        try {
            TosResponse tosResponseY = bVar.y(nVarA, arrayList);
            try {
                RestoreObjectOutput requestInfo = new RestoreObjectOutput().setRequestInfo(tosResponseY.b());
                tosResponseY.close();
                return requestInfo;
            } finally {
            }
        } catch (IOException e) {
            throw new TosClientException("tos: close body failed", e);
        }
    }

    @Override // com.volcengine.tos.TOSV2
    public final ResumableCopyObjectOutput resumableCopyObject(ResumableCopyObjectInput resumableCopyObjectInput) throws InterruptedException, IOException {
        ResumableCopyObjectCheckpoint resumableCopyObjectCheckpointK0;
        String ssecAlgorithm;
        String ssecKeyMD5;
        boolean z10;
        int i;
        j jVar = this.d;
        C0234l c0234l = jVar.b;
        boolean z11 = jVar.c;
        AbstractC0307c.a(resumableCopyObjectInput, "ResumableCopyObjectInput");
        String bucket = resumableCopyObjectInput.getBucket();
        String key = resumableCopyObjectInput.getKey();
        AbstractC0307c.b(bucket);
        AbstractC0307c.c(key);
        String srcBucket = resumableCopyObjectInput.getSrcBucket();
        String srcKey = resumableCopyObjectInput.getSrcKey();
        AbstractC0307c.b(srcBucket);
        AbstractC0307c.c(srcKey);
        AbstractC0307c.a(c0234l, "TosObjectRequestHandler");
        if (resumableCopyObjectInput.getPartSize() == 0) {
            resumableCopyObjectInput.setPartSize(20971520L);
        }
        Z6.k.Q(resumableCopyObjectInput.getPartSize());
        int taskNum = resumableCopyObjectInput.getTaskNum();
        if (taskNum > 1000) {
            taskNum = 1000;
        } else if (taskNum < 1) {
            taskNum = 1;
        }
        resumableCopyObjectInput.setTaskNum(taskNum);
        if (resumableCopyObjectInput.isEnableCheckpoint()) {
            String str = Z6.k.n(resumableCopyObjectInput.getBucket(), resumableCopyObjectInput.getKey(), "") + ".copy";
            if (AbstractC0291a.x(resumableCopyObjectInput.getCheckpointFile())) {
                throw new TosClientException("tos: ResumableCopyObject enable checkpoint but checkpoint file path is not set.", null);
            }
            if (new File(resumableCopyObjectInput.getCheckpointFile()).isDirectory()) {
                resumableCopyObjectInput.setCheckpointFile(resumableCopyObjectInput.getCheckpointFile() + File.separator + str);
            }
            AbstractC0307c.a(resumableCopyObjectInput.getCheckpointFile(), "checkpointFilePath");
        }
        try {
            GetObjectBasicOutput headObjectBasicOutput = c0234l.o(new HeadObjectV2Input().setBucket(resumableCopyObjectInput.getSrcBucket()).setKey(resumableCopyObjectInput.getSrcKey())).getHeadObjectBasicOutput();
            CopySourceObjectInfo lastModified = new CopySourceObjectInfo().setObjectSize(headObjectBasicOutput.getContentLength()).setHashCrc64ecma(headObjectBasicOutput.getHashCrc64ecma()).setEtag(headObjectBasicOutput.getEtag()).setLastModified(headObjectBasicOutput.getLastModifiedInDate());
            if (resumableCopyObjectInput.isEnableCheckpoint()) {
                try {
                    resumableCopyObjectCheckpointK0 = M.a.k0(resumableCopyObjectInput.getCheckpointFile());
                } catch (IOException | ClassNotFoundException unused) {
                    Z6.k.u(resumableCopyObjectInput.getCheckpointFile());
                }
            } else {
                resumableCopyObjectCheckpointK0 = null;
            }
            boolean zIsValid = resumableCopyObjectCheckpointK0 != null ? resumableCopyObjectCheckpointK0.isValid(lastModified, resumableCopyObjectInput.getBucket(), resumableCopyObjectInput.getKey(), resumableCopyObjectInput.getSrcBucket(), resumableCopyObjectInput.getSrcKey(), resumableCopyObjectInput.getSrcVersionID()) : false;
            if (!zIsValid) {
                Z6.k.u(resumableCopyObjectInput.getCheckpointFile());
            }
            if (resumableCopyObjectCheckpointK0 == null || !zIsValid) {
                if (resumableCopyObjectInput.getOptions() != null) {
                    ssecAlgorithm = resumableCopyObjectInput.getOptions().getSsecAlgorithm();
                    ssecKeyMD5 = resumableCopyObjectInput.getOptions().getSsecKeyMD5();
                } else {
                    ssecAlgorithm = null;
                    ssecKeyMD5 = null;
                }
                ResumableCopyObjectCheckpoint srcKey2 = new ResumableCopyObjectCheckpoint().setBucket(resumableCopyObjectInput.getBucket()).setKey(resumableCopyObjectInput.getKey()).setSrcBucket(resumableCopyObjectInput.getSrcBucket()).setSrcKey(resumableCopyObjectInput.getSrcKey());
                long objectSize = lastModified.getObjectSize();
                long partSize = resumableCopyObjectInput.getPartSize();
                long j5 = objectSize / partSize;
                long j6 = objectSize % partSize;
                if (j6 != 0) {
                    j5++;
                }
                String str2 = ssecAlgorithm;
                long j10 = j5;
                if (j10 > 10000) {
                    throw new TosClientException("unsupported part number, the maximum is 10000", null);
                }
                ArrayList arrayList = new ArrayList((int) j10);
                z10 = z11;
                int i6 = 0;
                while (true) {
                    long j11 = i6;
                    if (j11 >= j10) {
                        break;
                    }
                    long j12 = j10 - 1;
                    if (j11 < j12) {
                        int i10 = i6 + 1;
                        i = i6;
                        arrayList.add(new CopyPartInfo().setPartNumber(i10).setCopySourceRangeStart(j11 * partSize).setCopySourceRangeEnd((i10 * partSize) - 1));
                    } else {
                        i = i6;
                        arrayList.add(new CopyPartInfo().setPartNumber(i + 1).setCopySourceRangeStart(j11 * partSize).setCopySourceRangeEnd(((j12 * partSize) + j6) - 1));
                    }
                    i6 = i + 1;
                }
                if (j10 == 0) {
                    arrayList.add(new CopyPartInfo().setPartNumber(1).setCopySourceRangeStart(0L).setCopySourceRangeEnd(0L));
                }
                resumableCopyObjectCheckpointK0 = srcKey2.setCopyPartInfoList(arrayList).setCopySourceObjectInfo(lastModified).setPartSize(resumableCopyObjectInput.getPartSize()).setCopySourceIfMatch(resumableCopyObjectInput.getCopySourceIfMatch() == null ? lastModified.getEtag() : resumableCopyObjectInput.getCopySourceIfMatch()).setCopySourceIfModifiedSince(resumableCopyObjectInput.getCopySourceIfModifiedSince()).setCopySourceIfNoneMatch(resumableCopyObjectInput.getCopySourceIfNoneMatch()).setCopySourceIfUnModifiedSince(resumableCopyObjectInput.getCopySourceIfUnModifiedSince()).setCopySourceSSECAlgorithm(resumableCopyObjectInput.getCopySourceSSECAlgorithm()).setCopySourceSSECKeyMD5(resumableCopyObjectInput.getCopySourceSSECKeyMD5()).setSsecAlgorithm(str2).setSsecKeyMD5(ssecKeyMD5);
                CopyEvent srcVersionID = new CopyEvent().setBucket(resumableCopyObjectInput.getBucket()).setKey(resumableCopyObjectInput.getKey()).setCheckpointFile(resumableCopyObjectInput.getCheckpointFile()).setSrcBucket(resumableCopyObjectInput.getSrcBucket()).setSrcKey(resumableCopyObjectInput.getSrcKey()).setSrcVersionID(resumableCopyObjectInput.getSrcVersionID());
                try {
                    CreateMultipartUploadOutput createMultipartUploadOutputH = c0234l.h(new CreateMultipartUploadInput().setBucket(resumableCopyObjectInput.getBucket()).setKey(resumableCopyObjectInput.getKey()).setOptions(resumableCopyObjectInput.getOptions()).setEncodingType(resumableCopyObjectInput.getEncodingType()));
                    Z6.k.K(resumableCopyObjectInput.getCopyEventListener(), srcVersionID.setUploadID(createMultipartUploadOutputH.getUploadID()).setType(CopyEventType.f4233a));
                    resumableCopyObjectCheckpointK0.setUploadID(createMultipartUploadOutputH.getUploadID()).setEncodingType(createMultipartUploadOutputH.getEncodingType());
                    if (resumableCopyObjectInput.isEnableCheckpoint()) {
                        try {
                            resumableCopyObjectCheckpointK0.writeToFile(resumableCopyObjectInput.getCheckpointFile());
                        } catch (IOException e) {
                            throw new TosClientException("tos: record to checkpoint file failed", e);
                        }
                    }
                } catch (TosException e6) {
                    Z6.k.K(resumableCopyObjectInput.getCopyEventListener(), srcVersionID.setException(e6).setType(CopyEventType.b));
                    throw e6;
                }
            } else {
                z10 = z11;
            }
            int size = resumableCopyObjectCheckpointK0.getCopyPartInfoList().size();
            String bucket2 = resumableCopyObjectCheckpointK0.getBucket();
            String key2 = resumableCopyObjectCheckpointK0.getKey();
            String uploadID = resumableCopyObjectCheckpointK0.getUploadID();
            String checkpointFile = resumableCopyObjectInput.getCheckpointFile();
            boolean zIsEnableCheckpoint = resumableCopyObjectInput.isEnableCheckpoint();
            Z6.f fVar = new Z6.f();
            fVar.f1604a = c0234l;
            fVar.g = null;
            fVar.b = bucket2;
            fVar.c = key2;
            fVar.d = uploadID;
            fVar.e = checkpointFile;
            fVar.f = zIsEnableCheckpoint;
            fVar.i = new ReentrantLock();
            K1.a aVar = new K1.a(resumableCopyObjectInput.getTaskNum(), size, fVar);
            if (resumableCopyObjectInput.getCancelHook() != null && (resumableCopyObjectInput.getCancelHook() instanceof Z6.f)) {
                Z6.f fVar2 = (Z6.f) resumableCopyObjectInput.getCancelHook();
                fVar2.f1604a = c0234l;
                fVar2.g = aVar;
                fVar2.b = resumableCopyObjectCheckpointK0.getBucket();
                fVar2.c = resumableCopyObjectCheckpointK0.getKey();
                fVar2.d = resumableCopyObjectCheckpointK0.getUploadID();
                fVar2.f = resumableCopyObjectInput.isEnableCheckpoint();
                fVar2.e = resumableCopyObjectInput.getCheckpointFile();
            }
            ArrayList arrayList2 = new ArrayList(size);
            for (int i11 = 0; i11 < resumableCopyObjectCheckpointK0.getCopyPartInfoList().size(); i11++) {
                if (resumableCopyObjectCheckpointK0.getCopyPartInfoList().get(i11).isCompleted()) {
                    CopyPartInfo copyPartInfo = resumableCopyObjectCheckpointK0.getCopyPartInfoList().get(i11);
                    arrayList2.add(new UploadedPartV2().setPartNumber(copyPartInfo.getPartNumber()).setEtag(copyPartInfo.getEtag()));
                } else {
                    e eVar = new e();
                    AbstractC0307c.a(resumableCopyObjectCheckpointK0, "ResumableCopyObjectCheckpoint");
                    AbstractC0307c.a(resumableCopyObjectCheckpointK0.getCopySourceObjectInfo(), "CopySourceObjectInfo");
                    AbstractC0307c.a(resumableCopyObjectCheckpointK0.getCopyPartInfoList(), "CopyPartInfo list");
                    eVar.f1602a = resumableCopyObjectCheckpointK0;
                    eVar.c = resumableCopyObjectCheckpointK0.getCopyPartInfoList().get(i11);
                    eVar.d = resumableCopyObjectInput.isEnableCheckpoint();
                    eVar.e = resumableCopyObjectInput.getCheckpointFile();
                    eVar.f = resumableCopyObjectInput.getCopyEventListener();
                    eVar.i = resumableCopyObjectInput.getOptions();
                    eVar.b = resumableCopyObjectInput.getCopySourceSSECKey();
                    eVar.g = c0234l;
                    eVar.f1603j = resumableCopyObjectInput.getTrafficLimit();
                    ((ArrayList) aVar.d).add(eVar);
                }
            }
            aVar.f();
            Iterator it = ((ArrayList) aVar.c).iterator();
            while (it.hasNext()) {
                UploadPartCopyV2Output uploadPartCopyV2Output = (UploadPartCopyV2Output) ((Z6.g) it.next()).a();
                if (uploadPartCopyV2Output != null) {
                    arrayList2.add(new UploadedPartV2().setPartNumber(uploadPartCopyV2Output.getPartNumber()).setEtag(uploadPartCopyV2Output.getEtag()));
                }
            }
            if (resumableCopyObjectCheckpointK0.getBucket() != null && resumableCopyObjectCheckpointK0.getKey() != null && resumableCopyObjectCheckpointK0.getUploadID() != null && resumableCopyObjectCheckpointK0.getCopyPartInfoList() != null && resumableCopyObjectCheckpointK0.getCopySourceObjectInfo() != null && arrayList2.size() == resumableCopyObjectCheckpointK0.getCopyPartInfoList().size()) {
                Iterator<CopyPartInfo> it2 = resumableCopyObjectCheckpointK0.getCopyPartInfoList().iterator();
                while (it2.hasNext()) {
                    if (it2.next().isCompleted()) {
                    }
                }
                CompleteMultipartUploadV2Input uploadedParts = new CompleteMultipartUploadV2Input().setBucket(resumableCopyObjectCheckpointK0.getBucket()).setKey(resumableCopyObjectCheckpointK0.getKey()).setUploadID(resumableCopyObjectCheckpointK0.getUploadID()).setUploadedParts(arrayList2);
                CopyEvent srcVersionID2 = new CopyEvent().setUploadID(resumableCopyObjectCheckpointK0.getUploadID()).setBucket(resumableCopyObjectCheckpointK0.getBucket()).setKey(resumableCopyObjectCheckpointK0.getKey()).setCheckpointFile(resumableCopyObjectInput.getCheckpointFile()).setSrcBucket(resumableCopyObjectInput.getSrcBucket()).setSrcKey(resumableCopyObjectInput.getSrcKey()).setSrcVersionID(resumableCopyObjectInput.getSrcVersionID());
                try {
                    CompleteMultipartUploadV2Output completeMultipartUploadV2OutputF = c0234l.f(uploadedParts);
                    if (z10) {
                        String hashCrc64ecma = resumableCopyObjectCheckpointK0.getCopySourceObjectInfo().getHashCrc64ecma();
                        String hashCrc64ecma2 = completeMultipartUploadV2OutputF.getHashCrc64ecma();
                        if (!AbstractC0291a.s(hashCrc64ecma, hashCrc64ecma2)) {
                            throw new TosClientException("tos: expect crc64 " + hashCrc64ecma + ", actual crc64 " + hashCrc64ecma2, null);
                        }
                    }
                    Z6.k.K(resumableCopyObjectInput.getCopyEventListener(), srcVersionID2.setType(CopyEventType.f));
                    if (resumableCopyObjectInput.isEnableCheckpoint()) {
                        Z6.k.u(resumableCopyObjectInput.getCheckpointFile());
                    }
                    return new ResumableCopyObjectOutput().setRequestInfo(completeMultipartUploadV2OutputF.getRequestInfo()).setBucket(completeMultipartUploadV2OutputF.getBucket()).setKey(completeMultipartUploadV2OutputF.getKey()).setUploadID(resumableCopyObjectCheckpointK0.getUploadID()).setEtag(completeMultipartUploadV2OutputF.getEtag()).setLocation(completeMultipartUploadV2OutputF.getLocation()).setHashCrc64ecma(completeMultipartUploadV2OutputF.getHashCrc64ecma()).setVersionID(completeMultipartUploadV2OutputF.getVersionID()).setSsecAlgorithm(resumableCopyObjectCheckpointK0.getSsecAlgorithm()).setSsecKeyMD5(resumableCopyObjectCheckpointK0.getSsecKeyMD5()).setEncodingType(resumableCopyObjectCheckpointK0.getEncodingType());
                } catch (TosException e9) {
                    Z6.k.K(resumableCopyObjectInput.getCopyEventListener(), srcVersionID2.setException(e9).setType(CopyEventType.g));
                    throw e9;
                }
            }
            throw new TosClientException("tos: some copy tasks failed. bucket is " + resumableCopyObjectInput.getBucket() + ", dest key is " + resumableCopyObjectInput.getKey() + ", source key is " + resumableCopyObjectInput.getSrcKey(), null);
        } catch (TosException e10) {
            throw new TosClientException("tos: ResumableCopyObject get copySourceObject info failed", e10);
        }
    }

    @Override // com.volcengine.tos.TOSV2
    public final SetObjectMetaOutput setObjectMeta(SetObjectMetaInput setObjectMetaInput) {
        return this.c.w(setObjectMetaInput);
    }

    @Override // com.volcengine.tos.TOSV2
    public final UploadFileV2Output uploadFile(UploadFileV2Input uploadFileV2Input) {
        return this.d.a(uploadFileV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final UploadPartV2Output uploadPart(UploadPartV2Input uploadPartV2Input) {
        return this.c.z(uploadPartV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final UploadPartCopyV2Output uploadPartCopy(UploadPartCopyV2Input uploadPartCopyV2Input) {
        return this.c.A(uploadPartCopyV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final UploadPartFromFileOutput uploadPartFromFile(UploadPartFromFileInput uploadPartFromFileInput) throws IOException {
        j jVar = this.d;
        jVar.getClass();
        AbstractC0307c.a(uploadPartFromFileInput, "UploadPartFromFileInput");
        return new UploadPartFromFileOutput(jVar.b.z(UploadPartV2Input.builder().uploadPartBasicInput(uploadPartFromFileInput.getUploadPartBasicInput()).content(Z6.k.w(uploadPartFromFileInput.getFileInputStream(), uploadPartFromFileInput.getFile(), uploadPartFromFileInput.getFilePath(), uploadPartFromFileInput.getOffset(), uploadPartFromFileInput.getPartSize())).contentLength(uploadPartFromFileInput.getPartSize()).build()));
    }

    @Override // com.volcengine.tos.TOSV2
    public final AbortMultipartUploadOutput abortMultipartUpload(String str, AbortMultipartUploadInput abortMultipartUploadInput) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(abortMultipartUploadInput, "AbortMultipartUploadInput");
        return iVar.b.a(abortMultipartUploadInput.setBucket(str).setKey(abortMultipartUploadInput.getKey()).setUploadID(abortMultipartUploadInput.getUploadID()));
    }

    @Override // com.volcengine.tos.TOSV2
    public final CompleteMultipartUploadOutput completeMultipartUpload(String str, CompleteMultipartUploadInput completeMultipartUploadInput) {
        ArrayList arrayList;
        InnerUploadedPart innerUploadedPartUploadedPart;
        InnerUploadedPart innerUploadedPartUploadedPart2;
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(completeMultipartUploadInput, "CompleteMultipartUploadInput");
        CompleteMultipartUploadV2Input key = new CompleteMultipartUploadV2Input().setBucket(str).setUploadID(completeMultipartUploadInput.getUploadID()).setKey(completeMultipartUploadInput.getKey());
        int i = 0;
        ArrayList arrayList2 = null;
        if (completeMultipartUploadInput.getMultiUploadedParts() == null) {
            if (completeMultipartUploadInput.getUploadedParts() != null) {
                arrayList = new ArrayList(completeMultipartUploadInput.getMultiUploadedParts().size());
                MultipartUploadedPart[] uploadedParts = completeMultipartUploadInput.getUploadedParts();
                int length = uploadedParts.length;
                while (i < length) {
                    MultipartUploadedPart multipartUploadedPart = uploadedParts[i];
                    arrayList.add((multipartUploadedPart == null || (innerUploadedPartUploadedPart = multipartUploadedPart.uploadedPart()) == null) ? null : new UploadedPartV2().setEtag(innerUploadedPartUploadedPart.getEtag()).setPartNumber(innerUploadedPartUploadedPart.getPartNumber()));
                    i++;
                }
            }
            CompleteMultipartUploadV2Output completeMultipartUploadV2OutputF = iVar.b.f(key.setUploadedParts(arrayList2));
            return new CompleteMultipartUploadOutput().setRequestInfo(completeMultipartUploadV2OutputF.getRequestInfo()).setVersionID(completeMultipartUploadV2OutputF.getVersionID()).setCrc64(completeMultipartUploadV2OutputF.getHashCrc64ecma());
        }
        arrayList = new ArrayList(completeMultipartUploadInput.getMultiUploadedParts().size());
        MultipartUploadedPart[] uploadedParts2 = completeMultipartUploadInput.getUploadedParts();
        int length2 = uploadedParts2.length;
        while (i < length2) {
            MultipartUploadedPart multipartUploadedPart2 = uploadedParts2[i];
            arrayList.add((multipartUploadedPart2 == null || (innerUploadedPartUploadedPart2 = multipartUploadedPart2.uploadedPart()) == null) ? null : new UploadedPartV2().setEtag(innerUploadedPartUploadedPart2.getEtag()).setPartNumber(innerUploadedPartUploadedPart2.getPartNumber()));
            i++;
        }
        arrayList2 = arrayList;
        CompleteMultipartUploadV2Output completeMultipartUploadV2OutputF2 = iVar.b.f(key.setUploadedParts(arrayList2));
        return new CompleteMultipartUploadOutput().setRequestInfo(completeMultipartUploadV2OutputF2.getRequestInfo()).setVersionID(completeMultipartUploadV2OutputF2.getVersionID()).setCrc64(completeMultipartUploadV2OutputF2.getHashCrc64ecma());
    }

    @Override // com.volcengine.tos.TOSV2
    public final CopyObjectOutput copyObject(String str, String str2, String str3, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        return iVar.a(new CopyObjectV2Input().setBucket(str).setKey(str3).setSrcKey(str2).setSrcBucket(str), fVarArr);
    }

    @Override // com.volcengine.tos.TOSV2
    public final CreateMultipartUploadOutput createMultipartUpload(String str, String str2, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        CreateMultipartUploadInput key = new CreateMultipartUploadInput().setBucket(str).setKey(str2);
        if (fVarArr != null && fVarArr.length > 0) {
            HashMap map = new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
            if (map.size() > 0) {
                key.setOptions(new ObjectMetaRequestOptions().setHeaders(map));
            }
        }
        return iVar.b.h(key);
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketOutput deleteBucket(DeleteBucketInput deleteBucketInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(deleteBucketInput, "DeleteBucketInput");
        c1621a.n(deleteBucketInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(deleteBucketInput.getBucket(), "", null);
        ((o) c1621a.b).getClass();
        n nVarA = o.a(cVarC, "DELETE", null);
        nVarA.g = false;
        return (DeleteBucketOutput) ((A0.b) c1621a.f4793a).z(nVarA, ComposerKt.providerMapsKey, new G4.a(26));
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteBucketPolicyOutput deleteBucketPolicy(DeleteBucketPolicyInput deleteBucketPolicyInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(deleteBucketPolicyInput, "DeleteBucketPolicyInput");
        c1621a.n(deleteBucketPolicyInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(deleteBucketPolicyInput.getBucket(), "", null);
        cVarC.d(PolicySdkConstants.policyFileDir, "");
        ((o) c1621a.b).getClass();
        return (DeleteBucketPolicyOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "DELETE", null), ComposerKt.providerMapsKey, new G4.a(13));
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteMultiObjectsOutput deleteMultiObjects(String str, DeleteMultiObjectsInput deleteMultiObjectsInput, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(deleteMultiObjectsInput, "DeleteMultiObjectsInput");
        DeleteMultiObjectsV2Input quiet = new DeleteMultiObjectsV2Input().setBucket(str).setQuiet(deleteMultiObjectsInput.isQuiet());
        if (deleteMultiObjectsInput.getObjectTobeDeleteds() != null) {
            quiet.setObjects(new ArrayList(Arrays.asList(deleteMultiObjectsInput.getObjectTobeDeleteds())));
        }
        DeleteMultiObjectsV2Output deleteMultiObjectsV2OutputI = iVar.b.i(quiet);
        DeleteMultiObjectsOutput requestInfo = new DeleteMultiObjectsOutput().setRequestInfo(deleteMultiObjectsV2OutputI.getRequestInfo());
        if (deleteMultiObjectsV2OutputI.getDeleteds() != null) {
            Deleted[] deletedArr = new Deleted[deleteMultiObjectsV2OutputI.getDeleteds().size()];
            for (int i = 0; i < deleteMultiObjectsV2OutputI.getDeleteds().size(); i++) {
                deletedArr[i] = deleteMultiObjectsV2OutputI.getDeleteds().get(i);
            }
            requestInfo.setDeleteds(deletedArr);
        }
        if (deleteMultiObjectsV2OutputI.getErrors() != null) {
            DeleteError[] deleteErrorArr = new DeleteError[deleteMultiObjectsV2OutputI.getDeleteds().size()];
            for (int i6 = 0; i6 < deleteMultiObjectsV2OutputI.getDeleteds().size(); i6++) {
                deleteErrorArr[i6] = deleteMultiObjectsV2OutputI.getErrors().get(i6);
            }
            requestInfo.setErrors(deleteErrorArr);
        }
        return requestInfo;
    }

    @Override // com.volcengine.tos.TOSV2
    public final DeleteObjectOutput deleteObject(String str, String str2, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        DeleteObjectInput key = new DeleteObjectInput().setBucket(str).setKey(str2);
        if (fVarArr != null && fVarArr.length > 0) {
            new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
        }
        return iVar.b.j(key);
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetBucketPolicyOutput getBucketPolicy(GetBucketPolicyInput getBucketPolicyInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(getBucketPolicyInput, "GetBucketPolicyInput");
        c1621a.n(getBucketPolicyInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(getBucketPolicyInput.getBucket(), "", null);
        cVarC.d(PolicySdkConstants.policyFileDir, "");
        ((o) c1621a.b).getClass();
        return (GetBucketPolicyOutput) ((A0.b) c1621a.f4793a).z(o.a(cVarC, "GET", null), 200, new G4.a(29));
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetObjectOutput getObject(String str, String str2, X6.f... fVarArr) throws IOException {
        i iVar = this.f;
        iVar.getClass();
        GetObjectV2Input key = new GetObjectV2Input().setBucket(str).setKey(str2);
        if (fVarArr != null && fVarArr.length > 0) {
            HashMap map = new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
            if (map.size() > 0) {
                key.setOptions(new ObjectMetaRequestOptions().setHeaders(map));
            }
        }
        GetObjectV2Output getObjectV2OutputM = iVar.b.m(key);
        GetObjectOutput content = new GetObjectOutput().setContent(getObjectV2OutputM.getContent());
        if (getObjectV2OutputM.getGetObjectBasicOutput() != null) {
            content.setRequestInfo(getObjectV2OutputM.getGetObjectBasicOutput().getRequestInfo()).setObjectMeta(new ObjectMeta().fromGetObjectV2Output(getObjectV2OutputM.getGetObjectBasicOutput())).setContentRange(getObjectV2OutputM.getGetObjectBasicOutput().getContentRange());
        }
        return content;
    }

    @Override // com.volcengine.tos.TOSV2
    public final GetObjectAclOutput getObjectAcl(String str, String str2, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        GetObjectACLV2Input key = new GetObjectACLV2Input().setBucket(str).setKey(str2);
        Grant[] grantArr = null;
        if (fVarArr != null && fVarArr.length > 0) {
            new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
        }
        GetObjectACLV2Output getObjectACLV2OutputN = iVar.b.n(key);
        GetObjectAclOutput owner = new GetObjectAclOutput().setRequestInfo(getObjectACLV2OutputN.getRequestInfo()).setVersionId(getObjectACLV2OutputN.getVersionID()).setOwner(getObjectACLV2OutputN.getOwner());
        if (getObjectACLV2OutputN.getGrants() != null) {
            List<GrantV2> grants = getObjectACLV2OutputN.getGrants();
            if (grants != null) {
                Grant[] grantArr2 = new Grant[grants.size()];
                for (int i = 0; i < grants.size(); i++) {
                    GrantV2 grantV2 = grants.get(i);
                    Grant permission = new Grant().setPermission(grantV2.getPermission() == null ? null : grantV2.getPermission().f4225a);
                    if (grantV2.getGrantee() != null) {
                        GranteeV2 grantee = grantV2.getGrantee();
                        permission.setGrantee(new Grantee().setUri(grantee.getCanned() == null ? null : grantee.getCanned().f4221a).setType(grantee.getType() == null ? null : grantee.getType().f4223a).setId(grantee.getId()).setDisplayName(grantee.getDisplayName()));
                    }
                    grantArr2[i] = permission;
                }
                grantArr = grantArr2;
            }
            owner.setGrants(grantArr);
        }
        return owner;
    }

    @Override // com.volcengine.tos.TOSV2
    public final HeadBucketOutput headBucket(String str) {
        i iVar = this.f;
        iVar.getClass();
        HeadBucketV2Output headBucketV2OutputR = iVar.f1513a.r(HeadBucketV2Input.builder().bucket(str).build());
        return new HeadBucketOutput(headBucketV2OutputR.getRequestInfo(), headBucketV2OutputR.getRegion(), headBucketV2OutputR.getStorageClass() == null ? null : headBucketV2OutputR.getStorageClass().f4230a);
    }

    @Override // com.volcengine.tos.TOSV2
    public final HeadObjectOutput headObject(String str, String str2, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        HeadObjectV2Input key = new HeadObjectV2Input().setBucket(str).setKey(str2);
        if (fVarArr != null && fVarArr.length > 0) {
            HashMap map = new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
            if (map.size() > 0) {
                key.setOptions(new ObjectMetaRequestOptions().setHeaders(map));
            }
        }
        HeadObjectV2Output headObjectV2OutputO = iVar.b.o(key);
        return new HeadObjectOutput().setRequestInfo(headObjectV2OutputO.getRequestInfo()).setContentRange(headObjectV2OutputO.getContentRange()).setObjectMeta(new ObjectMeta().fromGetObjectV2Output(headObjectV2OutputO.getHeadObjectBasicOutput()));
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListBucketsOutput listBuckets(ListBucketsInput listBucketsInput) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(listBucketsInput, "ListBucketsInput");
        ListBucketsV2Output listBucketsV2OutputU = iVar.f1513a.u(new ListBucketsV2Input());
        ListBucketsOutput requestInfo = new ListBucketsOutput().setRequestInfo(listBucketsV2OutputU.getRequestInfo());
        if (listBucketsV2OutputU.getBuckets() != null) {
            ListedBucket[] listedBucketArr = new ListedBucket[listBucketsV2OutputU.getBuckets().size()];
            for (int i = 0; i < listBucketsV2OutputU.getBuckets().size(); i++) {
                listedBucketArr[i] = listBucketsV2OutputU.getBuckets().get(i);
            }
            requestInfo.setBuckets(listedBucketArr);
        }
        if (listBucketsV2OutputU.getOwner() != null) {
            Owner owner = listBucketsV2OutputU.getOwner();
            requestInfo.setOwner(new ListedOwner().setId(owner.getId()).setDisplayName(owner.getDisplayName()));
        }
        return requestInfo;
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListMultipartUploadsOutput listMultipartUploads(String str, ListMultipartUploadsInput listMultipartUploadsInput) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(listMultipartUploadsInput, "ListMultipartUploadsInput");
        ListMultipartUploadsV2Output listMultipartUploadsV2OutputP = iVar.b.p(new ListMultipartUploadsV2Input().setBucket(str).setMaxUploads(listMultipartUploadsInput.getMaxUploads()).setDelimiter(listMultipartUploadsInput.getDelimiter()).setPrefix(listMultipartUploadsInput.getPrefix()).setKeyMarker(listMultipartUploadsInput.getKeyMarker()).setUploadIDMarker(listMultipartUploadsInput.getUploadIDMarker()));
        ListMultipartUploadsOutput nextUploadIdMarker = new ListMultipartUploadsOutput().setMaxUploads(listMultipartUploadsV2OutputP.getMaxUploads()).setRequestInfo(listMultipartUploadsV2OutputP.getRequestInfo()).setBucket(listMultipartUploadsV2OutputP.getBucket()).setDelimiter(listMultipartUploadsV2OutputP.getDelimiter()).setKeyMarker(listMultipartUploadsV2OutputP.getKeyMarker()).setNextKeyMarker(listMultipartUploadsV2OutputP.getNextKeyMarker()).setTruncated(listMultipartUploadsV2OutputP.isTruncated()).setUploadIDMarker(listMultipartUploadsV2OutputP.getUploadIDMarker()).setNextUploadIdMarker(listMultipartUploadsV2OutputP.getNextUploadIdMarker());
        if (listMultipartUploadsV2OutputP.getUploads() != null) {
            UploadInfo[] uploadInfoArr = new UploadInfo[listMultipartUploadsV2OutputP.getUploads().size()];
            for (int i = 0; i < listMultipartUploadsV2OutputP.getUploads().size(); i++) {
                ListedUpload listedUpload = listMultipartUploadsV2OutputP.getUploads().get(i);
                uploadInfoArr[i] = new UploadInfo().setUploadID(listedUpload.getUploadID()).setInitiated(AbstractC0306b.a(listedUpload.getInitiated())).setKey(listedUpload.getKey()).setOwner(listedUpload.getOwner()).setStorageClass(listedUpload.getStorageClass() == null ? null : listedUpload.getStorageClass().f4230a);
            }
            nextUploadIdMarker.setUpload(uploadInfoArr);
        }
        if (listMultipartUploadsV2OutputP.getCommonPrefixes() != null) {
            UploadCommonPrefix[] uploadCommonPrefixArr = new UploadCommonPrefix[listMultipartUploadsV2OutputP.getCommonPrefixes().size()];
            for (int i6 = 0; i6 < listMultipartUploadsV2OutputP.getCommonPrefixes().size(); i6++) {
                uploadCommonPrefixArr[i6] = new UploadCommonPrefix().setPrefix(listMultipartUploadsV2OutputP.getCommonPrefixes().get(i6).getPrefix());
            }
            nextUploadIdMarker.setCommonPrefixes(uploadCommonPrefixArr);
        }
        return nextUploadIdMarker;
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListObjectVersionsOutput listObjectVersions(String str, ListObjectVersionsInput listObjectVersionsInput) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(listObjectVersionsInput, "ListObjectVersionsInput");
        ListObjectVersionsV2Output listObjectVersionsV2OutputQ = iVar.b.q(new ListObjectVersionsV2Input().setBucket(str).setPrefix(listObjectVersionsInput.getPrefix()).setDelimiter(listObjectVersionsInput.getDelimiter()).setEncodingType(listObjectVersionsInput.getEncodingType()).setMaxKeys(listObjectVersionsInput.getMaxKeys()).setKeyMarker(listObjectVersionsInput.getKeyMarker()).setVersionIDMarker(listObjectVersionsInput.getVersionIDMarker()));
        ListObjectVersionsOutput nextVersionIDMarker = new ListObjectVersionsOutput().setRequestInfo(listObjectVersionsV2OutputQ.getRequestInfo()).setPrefix(listObjectVersionsV2OutputQ.getPrefix()).setDelimiter(listObjectVersionsV2OutputQ.getDelimiter()).setMaxKeys(listObjectVersionsV2OutputQ.getMaxKeys()).setKeyMarker(listObjectVersionsV2OutputQ.getKeyMarker()).setNextKeyMarker(listObjectVersionsV2OutputQ.getNextKeyMarker()).setEncodingType(listObjectVersionsV2OutputQ.getEncodingType()).setName(listObjectVersionsV2OutputQ.getName()).setTruncated(listObjectVersionsV2OutputQ.isTruncated()).setVersionIDMarker(listObjectVersionsV2OutputQ.getVersionIDMarker()).setNextVersionIDMarker(listObjectVersionsV2OutputQ.getNextVersionIDMarker());
        if (listObjectVersionsV2OutputQ.getDeleteMarkers() != null) {
            ListedDeleteMarkerEntry[] listedDeleteMarkerEntryArr = new ListedDeleteMarkerEntry[listObjectVersionsV2OutputQ.getDeleteMarkers().size()];
            for (int i = 0; i < listObjectVersionsV2OutputQ.getDeleteMarkers().size(); i++) {
                listedDeleteMarkerEntryArr[i] = listObjectVersionsV2OutputQ.getDeleteMarkers().get(i);
            }
            nextVersionIDMarker.setDeleteMarkers(listedDeleteMarkerEntryArr);
        }
        if (listObjectVersionsV2OutputQ.getCommonPrefixes() != null) {
            ListedCommonPrefix[] listedCommonPrefixArr = new ListedCommonPrefix[listObjectVersionsV2OutputQ.getCommonPrefixes().size()];
            for (int i6 = 0; i6 < listObjectVersionsV2OutputQ.getCommonPrefixes().size(); i6++) {
                listedCommonPrefixArr[i6] = listObjectVersionsV2OutputQ.getCommonPrefixes().get(i6);
            }
            nextVersionIDMarker.setCommonPrefixes(listedCommonPrefixArr);
        }
        if (listObjectVersionsV2OutputQ.getVersions() != null) {
            ListedObjectVersion[] listedObjectVersionArr = new ListedObjectVersion[listObjectVersionsV2OutputQ.getVersions().size()];
            for (int i10 = 0; i10 < listObjectVersionsV2OutputQ.getVersions().size(); i10++) {
                listedObjectVersionArr[i10] = listObjectVersionsV2OutputQ.getVersions().get(i10);
            }
            nextVersionIDMarker.setVersions(listedObjectVersionArr);
        }
        return nextVersionIDMarker;
    }

    @Override // com.volcengine.tos.TOSV2
    public final ListObjectsOutput listObjects(String str, ListObjectsInput listObjectsInput) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(listObjectsInput, "ListObjectsInput");
        ListObjectsV2Output listObjectsV2OutputR = iVar.b.r(new ListObjectsV2Input().setBucket(str).setPrefix(listObjectsInput.getPrefix()).setDelimiter(listObjectsInput.getDelimiter()).setEncodingType(listObjectsInput.getEncodingType()).setMarker(listObjectsInput.getMarker()).setMaxKeys(listObjectsInput.getMaxKeys()).setReverse(listObjectsInput.isReverse()));
        ListObjectsOutput truncated = new ListObjectsOutput().setRequestInfo(listObjectsV2OutputR.getRequestInfo()).setPrefix(listObjectsV2OutputR.getPrefix()).setDelimiter(listObjectsV2OutputR.getDelimiter()).setMarker(listObjectsV2OutputR.getMarker()).setMaxKeys(listObjectsV2OutputR.getMaxKeys()).setEncodingType(listObjectsV2OutputR.getEncodingType()).setName(listObjectsV2OutputR.getName()).setNextMarker(listObjectsV2OutputR.getNextMarker()).setTruncated(listObjectsV2OutputR.isTruncated());
        if (listObjectsV2OutputR.getContents() != null) {
            ListedObject[] listedObjectArr = new ListedObject[listObjectsV2OutputR.getContents().size()];
            for (int i = 0; i < listObjectsV2OutputR.getContents().size(); i++) {
                ListedObjectV2 listedObjectV2 = listObjectsV2OutputR.getContents().get(i);
                listedObjectArr[i] = new ListedObject().setEtag(listedObjectV2.getEtag()).setKey(listedObjectV2.getKey()).setOwner(listedObjectV2.getOwner()).setSize(listedObjectV2.getSize()).setType(listedObjectV2.getType()).setLastModified(AbstractC0306b.a(listedObjectV2.getLastModified())).setStorageClass(listedObjectV2.getStorageClass());
            }
            truncated.setContents(listedObjectArr);
        }
        if (listObjectsV2OutputR.getCommonPrefixes() != null) {
            ListedCommonPrefix[] listedCommonPrefixArr = new ListedCommonPrefix[listObjectsV2OutputR.getCommonPrefixes().size()];
            for (int i6 = 0; i6 < listObjectsV2OutputR.getCommonPrefixes().size(); i6++) {
                listedCommonPrefixArr[i6] = listObjectsV2OutputR.getCommonPrefixes().get(i6);
            }
            truncated.setCommonPrefixes(listedCommonPrefixArr);
        }
        return truncated;
    }

    @Override // com.volcengine.tos.TOSV2
    public final String preSignedURL(String str, String str2, String str3, Duration duration, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        PreSignedURLInput httpMethod = new PreSignedURLInput().setBucket(str2).setKey(str3).setHttpMethod(str);
        if (duration != null) {
            httpMethod.setExpires(duration.getSeconds());
        }
        if (fVarArr != null && fVarArr.length > 0) {
            HashMap map = new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
            httpMethod.setQuery(null);
            httpMethod.setHeader(map);
        }
        return iVar.d.p(httpMethod).getSignedUrl();
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutBucketPolicyOutput putBucketPolicy(PutBucketPolicyInput putBucketPolicyInput) {
        C1621a c1621a = this.b;
        c1621a.getClass();
        AbstractC0307c.a(putBucketPolicyInput, "PutBucketPolicyInput");
        AbstractC0307c.a(putBucketPolicyInput.getPolicy(), PolicySdkConstants.policyFileDir);
        c1621a.n(putBucketPolicyInput.getBucket());
        X6.c cVarC = ((o) c1621a.b).c(putBucketPolicyInput.getBucket(), "", null);
        cVarC.d(PolicySdkConstants.policyFileDir, "");
        o oVar = (o) c1621a.b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(putBucketPolicyInput.getPolicy().getBytes(StandardCharsets.UTF_8));
        oVar.getClass();
        n nVarA = o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = putBucketPolicyInput.getPolicy().length();
        return (PutBucketPolicyOutput) ((A0.b) c1621a.f4793a).z(nVarA, ComposerKt.providerMapsKey, new G4.a(11));
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutObjectOutput putObject(String str, String str2, InputStream inputStream, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        PutObjectInput key = new PutObjectInput().setContent(inputStream).setBucket(str).setKey(str2);
        if (fVarArr != null && fVarArr.length > 0) {
            HashMap map = new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
            if (map.size() > 0) {
                key.setOptions(new ObjectMetaRequestOptions().setHeaders(map));
            }
        }
        return iVar.b.u(key);
    }

    @Override // com.volcengine.tos.TOSV2
    public final PutObjectAclOutput putObjectAcl(String str, PutObjectAclInput putObjectAclInput) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(putObjectAclInput, "PutObjectAclInput");
        PutObjectACLInput versionID = new PutObjectACLInput().setBucket(str).setKey(putObjectAclInput.getKey()).setVersionID(putObjectAclInput.getVersionId());
        if (putObjectAclInput.getAclGrant() != null) {
            versionID.setAcl(AbstractC0897f.s(putObjectAclInput.getAclGrant().getAcl()));
            versionID.setGrantFullControl(putObjectAclInput.getAclGrant().getGrantFullControl());
            versionID.setGrantRead(putObjectAclInput.getAclGrant().getGrantRead());
            versionID.setGrantReadAcp(putObjectAclInput.getAclGrant().getGrantReadAcp());
            versionID.setGrantWriteAcp(putObjectAclInput.getAclGrant().getGrantWriteAcp());
        }
        if (putObjectAclInput.getAclRules() != null) {
            ObjectAclRulesV2 owner = new ObjectAclRulesV2().setOwner(putObjectAclInput.getAclRules().getOwner());
            if (putObjectAclInput.getAclRules().getGrants() != null) {
                Grant[] grants = putObjectAclInput.getAclRules().getGrants();
                ArrayList arrayList = null;
                if (grants != null) {
                    ArrayList arrayList2 = new ArrayList(grants.length);
                    for (Grant grant : grants) {
                        GrantV2 grantV2 = new GrantV2();
                        String permission = grant.getPermission();
                        GrantV2 permission2 = grantV2.setPermission(permission == null ? null : permission.equals(ACLConst.PERMISSION_TYPE_FULL_CONTROL) ? PermissionType.PERMISSION_FULL_CONTROL : permission.equals(ACLConst.PERMISSION_TYPE_READ) ? PermissionType.PERMISSION_READ : permission.equals(ACLConst.PERMISSION_TYPE_READ_ACP) ? PermissionType.PERMISSION_READ_ACP : permission.equals(ACLConst.PERMISSION_TYPE_WRITE) ? PermissionType.PERMISSION_WRITE : permission.equals(ACLConst.PERMISSION_TYPE_WRITE_ACP) ? PermissionType.PERMISSION_WRITE_ACP : PermissionType.PERMISSION_UNKNOWN);
                        if (grant.getGrantee() != null) {
                            Grantee grantee = grant.getGrantee();
                            GranteeV2 granteeV2 = new GranteeV2();
                            String uri = grantee.getUri();
                            GranteeV2 displayName = granteeV2.setCanned(uri == null ? null : uri.equals("AllUsers") ? CannedType.CANNED_ALL_USERS : uri.equals("AuthenticatedUsers") ? CannedType.CANNED_AUTHENTICATED_USERS : uri.equals("LogDelivery") ? CannedType.CANNED_LOG_DELIVERY : CannedType.CANNED_UNKNOWN).setId(grantee.getId()).setDisplayName(grantee.getDisplayName());
                            String type = grantee.getType();
                            permission2.setGrantee(displayName.setType(type == null ? null : type.equals("Group") ? GranteeType.GRANTEE_GROUP : type.equals("CanonicalUser") ? GranteeType.GRANTEE_USER : GranteeType.GRANTEE_UNKNOWN));
                        }
                        arrayList2.add(permission2);
                    }
                    arrayList = arrayList2;
                }
                owner.setGrants(arrayList);
            }
            versionID.setObjectAclRules(owner);
        }
        return new PutObjectAclOutput().setRequestInfo(iVar.b.v(versionID).getRequestInfo());
    }

    @Override // com.volcengine.tos.TOSV2
    public final SetObjectMetaOutput setObjectMeta(String str, String str2, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        SetObjectMetaInput key = new SetObjectMetaInput().setBucket(str).setKey(str2);
        if (fVarArr != null && fVarArr.length > 0) {
            HashMap map = new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
            if (map.size() > 0) {
                key.setOptions(new ObjectMetaRequestOptions().setHeaders(map));
            }
        }
        return iVar.b.w(key);
    }

    @Override // com.volcengine.tos.TOSV2
    public final UploadFileOutput uploadFile(String str, UploadFileInput uploadFileInput, X6.f... fVarArr) throws InterruptedException, IOException {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(uploadFileInput, "UploadFileInput");
        UploadFileV2Input enableCheckpoint = new UploadFileV2Input().setBucket(str).setKey(uploadFileInput.getObjectKey()).setCheckpointFile(uploadFileInput.getCheckpointFile()).setFilePath(uploadFileInput.getUploadFilePath()).setPartSize(uploadFileInput.getPartSize()).setTaskNum(uploadFileInput.getTaskNum()).setEnableCheckpoint(uploadFileInput.isEnableCheckpoint());
        if (fVarArr != null && fVarArr.length > 0) {
            HashMap map = new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
            if (map.size() > 0) {
                enableCheckpoint.setOptions(new ObjectMetaRequestOptions().setHeaders(map));
            }
        }
        UploadFileV2Output uploadFileV2OutputA = iVar.c.a(enableCheckpoint);
        return new UploadFileOutput().setCompleteMultipartUploadOutput(new CompleteMultipartUploadOutput().setRequestInfo(uploadFileV2OutputA.getRequestInfo()).setVersionID(uploadFileV2OutputA.getVersionID()).setCrc64(uploadFileV2OutputA.getHashCrc64ecma())).setUploadID(uploadFileV2OutputA.getUploadID()).setBucket(uploadFileV2OutputA.getBucket()).setObjectKey(uploadFileV2OutputA.getKey());
    }

    @Override // com.volcengine.tos.TOSV2
    public final UploadPartOutput uploadPart(String str, UploadPartInput uploadPartInput, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(uploadPartInput, "UploadPartInput");
        UploadPartV2Input contentLength = new UploadPartV2Input().setBucket(str).setKey(uploadPartInput.getKey()).setPartNumber(uploadPartInput.getPartNumber()).setUploadID(uploadPartInput.getUploadID()).setContent(uploadPartInput.getContent()).setContentLength(uploadPartInput.getPartSize());
        if (fVarArr != null && fVarArr.length > 0) {
            HashMap map = new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
            if (map.size() > 0) {
                contentLength.setOptions(new ObjectMetaRequestOptions().setHeaders(map));
            }
        }
        UploadPartV2Output uploadPartV2OutputZ = iVar.b.z(contentLength);
        return new UploadPartOutput().setRequestInfo(uploadPartV2OutputZ.getRequestInfo()).setEtag(uploadPartV2OutputZ.getEtag()).setPartNumber(uploadPartV2OutputZ.getPartNumber()).setSseCustomerAlgorithm(uploadPartV2OutputZ.getSsecAlgorithm()).setSseCustomerMD5(uploadPartV2OutputZ.getSsecKeyMD5());
    }

    @Override // com.volcengine.tos.TOSV2
    public final UploadPartCopyOutput uploadPartCopy(String str, UploadPartCopyInput uploadPartCopyInput, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(uploadPartCopyInput, "UploadPartCopyInput");
        UploadPartCopyV2Input copySourceRange = new UploadPartCopyV2Input().setBucket(str).setKey(uploadPartCopyInput.getDestinationKey()).setSourceBucket(uploadPartCopyInput.getSourceBucket()).setSourceKey(uploadPartCopyInput.getSourceKey()).setSourceVersionID(uploadPartCopyInput.getSourceVersionID()).setPartNumber(uploadPartCopyInput.getPartNumber()).setUploadID(uploadPartCopyInput.getUploadID()).setCopySourceRange(uploadPartCopyInput.getStartOffset(), (uploadPartCopyInput.getPartSize() + uploadPartCopyInput.getStartOffset()) - 1);
        if (fVarArr != null && fVarArr.length > 0) {
            HashMap map = new HashMap(1);
            if (fVarArr.length > 0) {
                X6.f fVar = fVarArr[0];
                throw null;
            }
            if (map.size() > 0) {
                copySourceRange.setOptions(new ObjectMetaRequestOptions().setHeaders(map));
            }
        }
        UploadPartCopyV2Output uploadPartCopyV2OutputA = iVar.b.A(copySourceRange);
        return new UploadPartCopyOutput().setPartNumber(uploadPartCopyV2OutputA.getPartNumber()).setEtag(uploadPartCopyV2OutputA.getEtag()).setSourceVersionID(uploadPartCopyV2OutputA.getCopySourceVersionID()).setRequestInfo(uploadPartCopyV2OutputA.getRequestInfo()).setLastModified(AbstractC0306b.a(uploadPartCopyV2OutputA.getLastModified()));
    }

    @Override // com.volcengine.tos.TOSV2
    public final CreateBucketV2Output createBucket(CreateBucketV2Input createBucketV2Input) {
        return this.b.k(createBucketV2Input);
    }

    @Override // com.volcengine.tos.TOSV2
    public final CreateBucketOutput createBucket(CreateBucketInput createBucketInput) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.a(createBucketInput, "CreateBucketInput");
        CreateBucketV2Output createBucketV2OutputK = iVar.f1513a.k(CreateBucketV2Input.builder().bucket(createBucketInput.getBucket()).acl(AbstractC0897f.s(createBucketInput.getAcl())).storageClass(AbstractC0897f.u(createBucketInput.getStorageClass())).grantFullControl(createBucketInput.getGrantFullControl()).grantRead(createBucketInput.getGrantRead()).grantReadAcp(createBucketInput.getGrantReadAcp()).grantWrite(createBucketInput.getGrantWrite()).grantWriteAcp(createBucketInput.getGrantWriteAcp()).build());
        return new CreateBucketOutput(createBucketV2OutputK.getRequestInfo(), createBucketV2OutputK.getLocation());
    }

    @Override // com.volcengine.tos.TOSV2
    public final AppendObjectOutput appendObject(String str, String str2, InputStream inputStream, long j5, X6.f... fVarArr) {
        i iVar = this.f;
        iVar.getClass();
        AbstractC0307c.b(str);
        AbstractC0307c.c(str2);
        X6.c cVarC = ((o) iVar.b.d).c(str, str2, null);
        HashMap map = cVarC.i;
        if (fVarArr.length <= 0) {
            cVarC.d("append", "");
            cVarC.d(TypedValues.CycleType.S_WAVE_OFFSET, String.valueOf(j5));
            if (AbstractC0291a.x((String) map.get(HttpHeaders.CONTENT_TYPE)) && cVarC.k) {
                map.put(HttpHeaders.CONTENT_TYPE, T6.a.a().b(str2));
            }
            n nVarA = o.a(cVarC, "POST", inputStream);
            nVarA.i = false;
            nVarA.h = false;
            nVarA.g = false;
            try {
                TosResponse tosResponseB = iVar.b(nVarA);
                try {
                    String strC = tosResponseB.c("X-Tos-Next-Append-Offset");
                    try {
                        AppendObjectOutput versionID = new AppendObjectOutput().setRequestInfo(tosResponseB.b()).setNextAppendOffset(Long.parseLong(strC)).setEtag(tosResponseB.c("ETag")).setCrc64(tosResponseB.c("x-tos-hash-crc64ecma")).setVersionID(tosResponseB.c("X-Tos-Version-Id"));
                        tosResponseB.close();
                        return versionID;
                    } catch (NumberFormatException e) {
                        throw new TosClientException("server return unexpected Next-Append-Offset header: " + strC, e);
                    }
                } finally {
                }
            } catch (IOException e6) {
                f.e.j(e6.toString(), "tos: close response body failed, {}");
                return null;
            }
        } else {
            X6.f fVar = fVarArr[0];
            throw null;
        }
    }
}
