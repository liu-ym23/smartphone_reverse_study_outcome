package com.volcengine.tos;

import S6.b;
import X6.f;
import com.volcengine.tos.model.acl.GetObjectAclOutput;
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
import com.volcengine.tos.model.object.CopyObjectOutput;
import com.volcengine.tos.model.object.CopyObjectV2Input;
import com.volcengine.tos.model.object.CopyObjectV2Output;
import com.volcengine.tos.model.object.CreateMultipartUploadInput;
import com.volcengine.tos.model.object.CreateMultipartUploadOutput;
import com.volcengine.tos.model.object.DeleteMultiObjectsInput;
import com.volcengine.tos.model.object.DeleteMultiObjectsOutput;
import com.volcengine.tos.model.object.DeleteMultiObjectsV2Input;
import com.volcengine.tos.model.object.DeleteMultiObjectsV2Output;
import com.volcengine.tos.model.object.DeleteObjectInput;
import com.volcengine.tos.model.object.DeleteObjectOutput;
import com.volcengine.tos.model.object.DeleteObjectTaggingInput;
import com.volcengine.tos.model.object.DeleteObjectTaggingOutput;
import com.volcengine.tos.model.object.DownloadFileInput;
import com.volcengine.tos.model.object.DownloadFileOutput;
import com.volcengine.tos.model.object.FetchObjectInput;
import com.volcengine.tos.model.object.FetchObjectOutput;
import com.volcengine.tos.model.object.GetObjectACLV2Input;
import com.volcengine.tos.model.object.GetObjectACLV2Output;
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
import com.volcengine.tos.model.object.PreSignedPolicyURLInput;
import com.volcengine.tos.model.object.PreSignedPolicyURLOutput;
import com.volcengine.tos.model.object.PreSignedPostSignatureInput;
import com.volcengine.tos.model.object.PreSignedPostSignatureOutput;
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
import com.volcengine.tos.model.object.ResumableCopyObjectInput;
import com.volcengine.tos.model.object.ResumableCopyObjectOutput;
import com.volcengine.tos.model.object.SetObjectMetaInput;
import com.volcengine.tos.model.object.SetObjectMetaOutput;
import com.volcengine.tos.model.object.UploadFileInput;
import com.volcengine.tos.model.object.UploadFileOutput;
import com.volcengine.tos.model.object.UploadFileV2Input;
import com.volcengine.tos.model.object.UploadFileV2Output;
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
import e7.C1424a;
import java.io.InputStream;
import java.time.Duration;

/* loaded from: classes3.dex */
public interface TOSV2 {
    AbortMultipartUploadOutput abortMultipartUpload(AbortMultipartUploadInput abortMultipartUploadInput) throws TosException;

    /* synthetic */ AbortMultipartUploadOutput abortMultipartUpload(String str, AbortMultipartUploadInput abortMultipartUploadInput) throws TosException;

    AppendObjectOutput appendObject(AppendObjectInput appendObjectInput) throws TosException;

    /* synthetic */ AppendObjectOutput appendObject(String str, String str2, InputStream inputStream, long j5, f... fVarArr) throws TosException;

    void changeCredentials(b bVar);

    void changeRegionAndEndpoint(String str, String str2);

    void changeTransportConfig(C1424a c1424a);

    /* synthetic */ CompleteMultipartUploadOutput completeMultipartUpload(String str, CompleteMultipartUploadInput completeMultipartUploadInput) throws TosException;

    CompleteMultipartUploadV2Output completeMultipartUpload(CompleteMultipartUploadV2Input completeMultipartUploadV2Input) throws TosException;

    /* synthetic */ CopyObjectOutput copyObject(String str, String str2, String str3, f... fVarArr) throws TosException;

    CopyObjectV2Output copyObject(CopyObjectV2Input copyObjectV2Input) throws TosException;

    /* synthetic */ CopyObjectOutput copyObjectFrom(String str, String str2, String str3, String str4, f... fVarArr) throws TosException;

    /* synthetic */ CopyObjectOutput copyObjectTo(String str, String str2, String str3, String str4, f... fVarArr) throws TosException;

    /* synthetic */ CreateBucketOutput createBucket(CreateBucketInput createBucketInput) throws TosException;

    CreateBucketV2Output createBucket(CreateBucketV2Input createBucketV2Input) throws TosException;

    CreateBucketV2Output createBucket(String str) throws TosException;

    CreateMultipartUploadOutput createMultipartUpload(CreateMultipartUploadInput createMultipartUploadInput) throws TosException;

    /* synthetic */ CreateMultipartUploadOutput createMultipartUpload(String str, String str2, f... fVarArr) throws TosException;

    DeleteBucketOutput deleteBucket(DeleteBucketInput deleteBucketInput) throws TosException;

    /* synthetic */ DeleteBucketOutput deleteBucket(String str) throws TosException;

    DeleteBucketCORSOutput deleteBucketCORS(DeleteBucketCORSInput deleteBucketCORSInput) throws TosException;

    DeleteBucketCustomDomainOutput deleteBucketCustomDomain(DeleteBucketCustomDomainInput deleteBucketCustomDomainInput) throws TosException;

    DeleteBucketLifecycleOutput deleteBucketLifecycle(DeleteBucketLifecycleInput deleteBucketLifecycleInput) throws TosException;

    DeleteBucketMirrorBackOutput deleteBucketMirrorBack(DeleteBucketMirrorBackInput deleteBucketMirrorBackInput) throws TosException;

    DeleteBucketPolicyOutput deleteBucketPolicy(DeleteBucketPolicyInput deleteBucketPolicyInput) throws TosException;

    DeleteBucketPolicyOutput deleteBucketPolicy(String str) throws TosException;

    DeleteBucketRealTimeLogOutput deleteBucketRealTimeLog(DeleteBucketRealTimeLogInput deleteBucketRealTimeLogInput) throws TosException;

    DeleteBucketRenameOutput deleteBucketRename(DeleteBucketRenameInput deleteBucketRenameInput) throws TosException;

    DeleteBucketReplicationOutput deleteBucketReplication(DeleteBucketReplicationInput deleteBucketReplicationInput) throws TosException;

    DeleteBucketWebsiteOutput deleteBucketWebsite(DeleteBucketWebsiteInput deleteBucketWebsiteInput) throws TosException;

    /* synthetic */ DeleteMultiObjectsOutput deleteMultiObjects(String str, DeleteMultiObjectsInput deleteMultiObjectsInput, f... fVarArr) throws TosException;

    DeleteMultiObjectsV2Output deleteMultiObjects(DeleteMultiObjectsV2Input deleteMultiObjectsV2Input) throws TosException;

    DeleteObjectOutput deleteObject(DeleteObjectInput deleteObjectInput) throws TosException;

    /* synthetic */ DeleteObjectOutput deleteObject(String str, String str2, f... fVarArr) throws TosException;

    DeleteObjectTaggingOutput deleteObjectTagging(DeleteObjectTaggingInput deleteObjectTaggingInput) throws TosException;

    DownloadFileOutput downloadFile(DownloadFileInput downloadFileInput) throws TosException;

    FetchObjectOutput fetchObject(FetchObjectInput fetchObjectInput) throws TosException;

    GetBucketACLOutput getBucketACL(GetBucketACLInput getBucketACLInput) throws TosException;

    GetBucketCORSOutput getBucketCORS(GetBucketCORSInput getBucketCORSInput) throws TosException;

    GetBucketLifecycleOutput getBucketLifecycle(GetBucketLifecycleInput getBucketLifecycleInput) throws TosException;

    GetBucketLocationOutput getBucketLocation(GetBucketLocationInput getBucketLocationInput) throws TosException;

    GetBucketMirrorBackOutput getBucketMirrorBack(GetBucketMirrorBackInput getBucketMirrorBackInput) throws TosException;

    GetBucketNotificationOutput getBucketNotification(GetBucketNotificationInput getBucketNotificationInput) throws TosException;

    GetBucketPolicyOutput getBucketPolicy(GetBucketPolicyInput getBucketPolicyInput) throws TosException;

    GetBucketPolicyOutput getBucketPolicy(String str) throws TosException;

    GetBucketRealTimeLogOutput getBucketRealTimeLog(GetBucketRealTimeLogInput getBucketRealTimeLogInput) throws TosException;

    GetBucketRenameOutput getBucketRename(GetBucketRenameInput getBucketRenameInput) throws TosException;

    GetBucketReplicationOutput getBucketReplication(GetBucketReplicationInput getBucketReplicationInput) throws TosException;

    GetBucketVersioningOutput getBucketVersioning(GetBucketVersioningInput getBucketVersioningInput) throws TosException;

    GetBucketWebsiteOutput getBucketWebsite(GetBucketWebsiteInput getBucketWebsiteInput) throws TosException;

    /* synthetic */ GetObjectOutput getObject(String str, String str2, f... fVarArr) throws TosException;

    GetObjectV2Output getObject(GetObjectV2Input getObjectV2Input) throws TosException;

    /* synthetic */ GetObjectAclOutput getObjectAcl(String str, String str2, f... fVarArr) throws TosException;

    GetObjectACLV2Output getObjectAcl(GetObjectACLV2Input getObjectACLV2Input) throws TosException;

    GetObjectTaggingOutput getObjectTagging(GetObjectTaggingInput getObjectTaggingInput) throws TosException;

    GetObjectToFileOutput getObjectToFile(GetObjectToFileInput getObjectToFileInput) throws TosException;

    /* synthetic */ HeadBucketOutput headBucket(String str) throws TosException;

    HeadBucketV2Output headBucket(HeadBucketV2Input headBucketV2Input) throws TosException;

    /* synthetic */ HeadObjectOutput headObject(String str, String str2, f... fVarArr) throws TosException;

    HeadObjectV2Output headObject(HeadObjectV2Input headObjectV2Input) throws TosException;

    ListBucketCustomDomainOutput listBucketCustomDomain(ListBucketCustomDomainInput listBucketCustomDomainInput) throws TosException;

    /* synthetic */ ListBucketsOutput listBuckets(ListBucketsInput listBucketsInput) throws TosException;

    ListBucketsV2Output listBuckets(ListBucketsV2Input listBucketsV2Input) throws TosException;

    /* synthetic */ ListMultipartUploadsOutput listMultipartUploads(String str, ListMultipartUploadsInput listMultipartUploadsInput) throws TosException;

    ListMultipartUploadsV2Output listMultipartUploads(ListMultipartUploadsV2Input listMultipartUploadsV2Input) throws TosException;

    /* synthetic */ ListObjectVersionsOutput listObjectVersions(String str, ListObjectVersionsInput listObjectVersionsInput) throws TosException;

    ListObjectVersionsV2Output listObjectVersions(ListObjectVersionsV2Input listObjectVersionsV2Input) throws TosException;

    /* synthetic */ ListObjectsOutput listObjects(String str, ListObjectsInput listObjectsInput) throws TosException;

    @Deprecated
    ListObjectsV2Output listObjects(ListObjectsV2Input listObjectsV2Input) throws TosException;

    ListObjectsType2Output listObjectsType2(ListObjectsType2Input listObjectsType2Input) throws TosException;

    ListPartsOutput listParts(ListPartsInput listPartsInput) throws TosException;

    /* synthetic */ ListUploadedPartsOutput listUploadedParts(String str, ListUploadedPartsInput listUploadedPartsInput, f... fVarArr) throws TosException;

    PreSignedPolicyURLOutput preSignedPolicyURL(PreSignedPolicyURLInput preSignedPolicyURLInput) throws TosException;

    PreSignedPostSignatureOutput preSignedPostSignature(PreSignedPostSignatureInput preSignedPostSignatureInput) throws TosException;

    PreSignedURLOutput preSignedURL(PreSignedURLInput preSignedURLInput) throws TosException;

    /* synthetic */ String preSignedURL(String str, String str2, String str3, Duration duration, f... fVarArr) throws TosException;

    PreSingedPolicyURLOutput preSingedPolicyURL(PreSingedPolicyURLInput preSingedPolicyURLInput) throws TosException;

    PutBucketACLOutput putBucketACL(PutBucketACLInput putBucketACLInput) throws TosException;

    PutBucketCORSOutput putBucketCORS(PutBucketCORSInput putBucketCORSInput) throws TosException;

    PutBucketCustomDomainOutput putBucketCustomDomain(PutBucketCustomDomainInput putBucketCustomDomainInput) throws TosException;

    PutBucketLifecycleOutput putBucketLifecycle(PutBucketLifecycleInput putBucketLifecycleInput) throws TosException;

    PutBucketMirrorBackOutput putBucketMirrorBack(PutBucketMirrorBackInput putBucketMirrorBackInput) throws TosException;

    PutBucketNotificationOutput putBucketNotification(PutBucketNotificationInput putBucketNotificationInput) throws TosException;

    PutBucketPolicyOutput putBucketPolicy(PutBucketPolicyInput putBucketPolicyInput) throws TosException;

    PutBucketPolicyOutput putBucketPolicy(String str, String str2) throws TosException;

    PutBucketRealTimeLogOutput putBucketRealTimeLog(PutBucketRealTimeLogInput putBucketRealTimeLogInput) throws TosException;

    PutBucketRenameOutput putBucketRename(PutBucketRenameInput putBucketRenameInput) throws TosException;

    PutBucketReplicationOutput putBucketReplication(PutBucketReplicationInput putBucketReplicationInput) throws TosException;

    PutBucketStorageClassOutput putBucketStorageClass(PutBucketStorageClassInput putBucketStorageClassInput) throws TosException;

    PutBucketVersioningOutput putBucketVersioning(PutBucketVersioningInput putBucketVersioningInput) throws TosException;

    PutBucketWebsiteOutput putBucketWebsite(PutBucketWebsiteInput putBucketWebsiteInput) throws TosException;

    PutFetchTaskOutput putFetchTask(PutFetchTaskInput putFetchTaskInput) throws TosException;

    PutObjectOutput putObject(PutObjectInput putObjectInput) throws TosException;

    /* synthetic */ PutObjectOutput putObject(String str, String str2, InputStream inputStream, f... fVarArr) throws TosException;

    /* synthetic */ PutObjectAclOutput putObjectAcl(String str, PutObjectAclInput putObjectAclInput) throws TosException;

    PutObjectACLOutput putObjectAcl(PutObjectACLInput putObjectACLInput) throws TosException;

    PutObjectFromFileOutput putObjectFromFile(PutObjectFromFileInput putObjectFromFileInput) throws TosException;

    PutObjectTaggingOutput putObjectTagging(PutObjectTaggingInput putObjectTaggingInput) throws TosException;

    RenameObjectOutput renameObject(RenameObjectInput renameObjectInput) throws TosException;

    RestoreObjectOutput restoreObject(RestoreObjectInput restoreObjectInput) throws TosException;

    ResumableCopyObjectOutput resumableCopyObject(ResumableCopyObjectInput resumableCopyObjectInput) throws TosException;

    SetObjectMetaOutput setObjectMeta(SetObjectMetaInput setObjectMetaInput) throws TosException;

    /* synthetic */ SetObjectMetaOutput setObjectMeta(String str, String str2, f... fVarArr) throws TosException;

    @Deprecated
    /* synthetic */ UploadFileOutput uploadFile(String str, UploadFileInput uploadFileInput, f... fVarArr) throws TosException;

    UploadFileV2Output uploadFile(UploadFileV2Input uploadFileV2Input) throws TosException;

    /* synthetic */ UploadPartOutput uploadPart(String str, UploadPartInput uploadPartInput, f... fVarArr) throws TosException;

    UploadPartV2Output uploadPart(UploadPartV2Input uploadPartV2Input) throws TosException;

    /* synthetic */ UploadPartCopyOutput uploadPartCopy(String str, UploadPartCopyInput uploadPartCopyInput, f... fVarArr) throws TosException;

    UploadPartCopyV2Output uploadPartCopy(UploadPartCopyV2Input uploadPartCopyV2Input) throws TosException;

    UploadPartFromFileOutput uploadPartFromFile(UploadPartFromFileInput uploadPartFromFileInput) throws TosException;
}
