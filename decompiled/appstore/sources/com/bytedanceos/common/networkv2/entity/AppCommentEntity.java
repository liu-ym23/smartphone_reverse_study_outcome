package com.bytedanceos.common.networkv2.entity;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppCommentEntity {
    private List<CommentEntity> comments;
    private String count;
    private List<AppScoreDetailEntity> score;
    private String scores;

    public class CommentEntity {
        private String content;
        private String create_time;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f9896id;
        private String iflike;
        private String is_black;
        private String like;
        private String nickname;
        private String score;
        final /* synthetic */ AppCommentEntity this$0;
        private String uid;
        private String version;

        public CommentEntity(AppCommentEntity r10) {
            this.this$0 = r10;
            this.f9896id = "";
            this.uid = "";
            this.content = "";
            this.score = "";
            this.version = "";
            this.create_time = "";
            this.nickname = "";
            this.iflike = "";
            this.like = "";
            this.is_black = "";
        }

        public String getContent() {
            return this.content;
        }

        public String getCreate_time() {
            return this.create_time;
        }

        public String getId() {
            return this.f9896id;
        }

        public String getIflike() {
            return this.iflike;
        }

        public String getIs_black() {
            return this.is_black;
        }

        public String getLike() {
            return this.like;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getScore() {
            return this.score;
        }

        public String getUid() {
            return this.uid;
        }

        public String getVersion() {
            return this.version;
        }

        public void setContent(String r10) {
            this.content = r10;
        }

        public void setCreate_time(String r10) {
            this.create_time = r10;
        }

        public void setId(String r10) {
            this.f9896id = r10;
        }

        public void setIflike(String r10) {
            this.iflike = r10;
        }

        public void setIs_black(String r10) {
            this.is_black = r10;
        }

        public void setLike(String r10) {
            this.like = r10;
        }

        public void setNickname(String r10) {
            this.nickname = r10;
        }

        public void setScore(String r10) {
            this.score = r10;
        }

        public void setUid(String r10) {
            this.uid = r10;
        }

        public void setVersion(String r10) {
            this.version = r10;
        }
    }

    public AppCommentEntity() {
        this.scores = "";
        this.count = "";
        this.score = new ArrayList();
        this.comments = new ArrayList();
    }
}
