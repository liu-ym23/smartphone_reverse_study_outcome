package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volcengine.tos.TosClientException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class CompleteMultipartUploadInput {
    private String key;
    private List<MultipartUploadedPart> multiUploadedParts = Collections.EMPTY_LIST;
    private String uploadID;
    private MultipartUploadedPart[] uploadedParts;

    public static class InnerCompleteMultipartUploadInput {

        @JsonProperty("Parts")
        private InnerUploadedPart[] parts;

        public InnerCompleteMultipartUploadInput(int i) {
            this.parts = new InnerUploadedPart[i];
        }

        public InnerUploadedPart[] getParts() {
            return this.parts;
        }

        public InnerCompleteMultipartUploadInput setParts(InnerUploadedPart[] innerUploadedPartArr) {
            this.parts = innerUploadedPartArr;
            return this;
        }

        public void setPartsByIdx(InnerUploadedPart innerUploadedPart, int i) {
            InnerUploadedPart[] innerUploadedPartArr = this.parts;
            if (i >= innerUploadedPartArr.length) {
                return;
            }
            innerUploadedPartArr[i] = innerUploadedPart;
        }

        public String toString() {
            return "{[" + this.parts[0] + " " + this.parts[1] + "]}";
        }
    }

    public CompleteMultipartUploadInput() {
    }

    private InnerCompleteMultipartUploadInput setMultiPart(MultipartUploadedPart[] multipartUploadedPartArr) {
        if (multipartUploadedPartArr == null || multipartUploadedPartArr.length == 0) {
            return null;
        }
        InnerCompleteMultipartUploadInput innerCompleteMultipartUploadInput = new InnerCompleteMultipartUploadInput(multipartUploadedPartArr.length);
        for (int i = 0; i < multipartUploadedPartArr.length; i++) {
            MultipartUploadedPart multipartUploadedPart = multipartUploadedPartArr[i];
            if (multipartUploadedPart == null) {
                return null;
            }
            innerCompleteMultipartUploadInput.setPartsByIdx(multipartUploadedPart.uploadedPart(), i);
        }
        Arrays.sort(innerCompleteMultipartUploadInput.getParts());
        return innerCompleteMultipartUploadInput;
    }

    public String getKey() {
        return this.key;
    }

    public List<MultipartUploadedPart> getMultiUploadedParts() {
        return this.multiUploadedParts;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public byte[] getUploadedPartData(ObjectMapper objectMapper) throws TosClientException {
        if (getUploadedPartsLength() == 0) {
            throw new TosClientException("tos: MultipartUploadedPart is null, please check your input first.", null);
        }
        InnerCompleteMultipartUploadInput multiPart = (getUploadedParts() == null || getUploadedParts().length == 0) ? getMultiUploadedParts().size() != 0 ? setMultiPart(getMultiUploadedParts()) : null : setMultiPart(getUploadedParts());
        if (multiPart == null) {
            throw new TosClientException("tos: can not get MultipartUploadedPart, please check your input first.", null);
        }
        try {
            return objectMapper.writeValueAsBytes(multiPart);
        } catch (JsonProcessingException e) {
            throw new TosClientException("tos: json parse exception", e);
        }
    }

    @Deprecated
    public MultipartUploadedPart[] getUploadedParts() {
        return this.uploadedParts;
    }

    public int getUploadedPartsLength() {
        MultipartUploadedPart[] multipartUploadedPartArr = this.uploadedParts;
        return (multipartUploadedPartArr == null || multipartUploadedPartArr.length == 0) ? this.multiUploadedParts.size() : multipartUploadedPartArr.length;
    }

    public CompleteMultipartUploadInput setKey(String str) {
        this.key = str;
        return this;
    }

    public CompleteMultipartUploadInput setMultiUploadedParts(List<MultipartUploadedPart> list) {
        this.multiUploadedParts = list;
        return this;
    }

    public CompleteMultipartUploadInput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    @Deprecated
    public void setUploadedParts(MultipartUploadedPart[] multipartUploadedPartArr) {
        this.uploadedParts = multipartUploadedPartArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CompleteMultipartUploadInput{key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        String strG = a.g('\'', this.uploadID, sb);
        MultipartUploadedPart[] multipartUploadedPartArr = this.uploadedParts;
        if (multipartUploadedPartArr != null && multipartUploadedPartArr.length != 0) {
            return a.g('}', Arrays.toString(this.uploadedParts), androidx.appfunctions.metadata.a.x(strG, ", uploadedParts="));
        }
        StringBuilder sbX = androidx.appfunctions.metadata.a.x(strG, ", uploadedParts=");
        sbX.append(Arrays.toString(this.multiUploadedParts.toArray()));
        sbX.append('}');
        return sbX.toString();
    }

    @Deprecated
    public CompleteMultipartUploadInput(String str, String str2, MultipartUploadedPart[] multipartUploadedPartArr) {
        this.key = str;
        this.uploadID = str2;
        this.uploadedParts = multipartUploadedPartArr;
    }

    private InnerCompleteMultipartUploadInput setMultiPart(List<MultipartUploadedPart> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        InnerCompleteMultipartUploadInput innerCompleteMultipartUploadInput = new InnerCompleteMultipartUploadInput(list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                return null;
            }
            innerCompleteMultipartUploadInput.setPartsByIdx(list.get(i).uploadedPart(), i);
        }
        Arrays.sort(innerCompleteMultipartUploadInput.getParts());
        return innerCompleteMultipartUploadInput;
    }
}
