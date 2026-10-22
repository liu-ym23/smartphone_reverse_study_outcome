package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class AccountRegisterWrap {
    private DataBean data;
    private int errno;

    public class DataBean {
        final /* synthetic */ AccountRegisterWrap this$0;
        private String ticket;
        private long ttl;
        private AccountUserBean user;

        public DataBean(AccountRegisterWrap r10) {
            this.this$0 = r10;
        }

        public String getTicket() {
            return this.ticket;
        }

        public long getTtl() {
            return this.ttl;
        }

        public AccountUserBean getUser() {
            return this.user;
        }

        public void setTicket(String r10) {
            this.ticket = r10;
        }

        public void setTtl(long r10) {
            this.ttl = r10;
        }

        public void setUser(AccountUserBean r10) {
            this.user = r10;
        }
    }

    public AccountRegisterWrap() {
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
