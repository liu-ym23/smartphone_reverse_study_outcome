package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class AccountLoginWrap {
    private DataBean data;
    private int errno;

    public class DataBean {
        private String captcha;
        final /* synthetic */ AccountLoginWrap this$0;
        private String ticket;
        private long ttl;
        private UserBean user;

        public class UserBean {
            final /* synthetic */ DataBean this$1;
            private long uid;

            public UserBean(DataBean r10) {
                this.this$1 = r10;
            }

            public long getUid() {
                return this.uid;
            }

            public void setUid(long r10) {
                this.uid = r10;
            }
        }

        public DataBean(AccountLoginWrap r10) {
            this.this$0 = r10;
        }

        public String getCaptcha() {
            return this.captcha;
        }

        public String getTicket() {
            return this.ticket;
        }

        public long getTtl() {
            return this.ttl;
        }

        public UserBean getUser() {
            return this.user;
        }

        public void setCaptcha(String r10) {
            this.captcha = r10;
        }

        public void setTicket(String r10) {
            this.ticket = r10;
        }

        public void setTtl(long r10) {
            this.ttl = r10;
        }

        public void setUser(UserBean r10) {
            this.user = r10;
        }
    }

    public AccountLoginWrap() {
    }

    public DataBean getData() {
        return this.data;
    }

    public int getErrno() {
        return this.errno;
    }

    public void setData(DataBean r10) {
        this.data = r10;
    }

    public void setErrno(int r10) {
        this.errno = r10;
    }
}
