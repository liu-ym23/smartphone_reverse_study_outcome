package com.byted.cast.common.source;

import com.byted.cast.common.bean.DramaBean;

/* JADX INFO: loaded from: classes39.dex */
public interface IPlayerListener {
    public static final int ERROR_CODE_BDDLNA_AVTRANS_SERVICE_NOT_EXIST = 22510001;
    public static final int ERROR_CODE_BDDLNA_AVTRANS_SERVICE_NOT_EXIST_2 = 22510002;
    public static final int ERROR_CODE_BDDLNA_AVTRANS_SERVICE_NOT_EXIST_3 = 22510003;
    public static final int ERROR_CODE_BDDLNA_CUSTOMIZED_CONSTRUCT_JSON = 22560002;
    public static final int ERROR_CODE_BDDLNA_CUSTOMIZED_INVALID_REPSONSE = 22560003;
    public static final int ERROR_CODE_BDDLNA_CUSTOMIZED_NON_DEVICE = 22560000;
    public static final int ERROR_CODE_BDDLNA_CUSTOMIZED_NON_PLAYERI_INFO = 22560001;
    public static final int ERROR_CODE_BDDLNA_CUSTOMIZED_PARSE_RESPONSE = 22560004;
    public static final int ERROR_CODE_BDDLNA_INVALID_PLAYER_INFO = 22000001;
    public static final int ERROR_CODE_BDDLNA_INVALID_PLAY_INFO = 22500003;
    public static final int ERROR_CODE_BDDLNA_INVALID_RESPONSE_STATUS = 22530003;
    public static final int ERROR_CODE_BDDLNA_NO_DEVICE = 22500002;
    public static final int ERROR_CODE_BDDLNA_NULL_ACTION_LIST = 22520001;
    public static final int ERROR_CODE_BDDLNA_NULL_AVTRANS_SERVICE = 22510000;
    public static final int ERROR_CODE_BDDLNA_NULL_PLAY_ACTION = 22520003;
    public static final int ERROR_CODE_BDDLNA_NULL_SCPD = 22520000;
    public static final int ERROR_CODE_BDDLNA_NULL_SETAVTRANS_ACTION = 22520002;
    public static final int ERROR_CODE_BDDLNA_NULL_STATUS = 22000002;
    public static final int ERROR_CODE_BDDLNA_PARSE_EXCEPTION = 22530004;
    public static final int ERROR_CODE_BDDLNA_PLAY_IO_EXCEPTION = 22530002;
    public static final int ERROR_CODE_BDDLNA_PLAY_SOCKET_EXCEPTION = 22530000;
    public static final int ERROR_CODE_BDDLNA_PLAY_SOCKET_TIMEOUT = 22530001;
    public static final int ERROR_CODE_BDLINK_ADD_VOLUME_INVALID_INFO = 23100402;
    public static final int ERROR_CODE_BDLINK_ADD_VOLUME_NO_RESPONSE = 23100401;
    public static final int ERROR_CODE_BDLINK_CLEAR_DRAMA_ID_IS_NULL = 23101504;
    public static final int ERROR_CODE_BDLINK_CLEAR_DRAMA_INVALID_INFO = 23101502;
    public static final int ERROR_CODE_BDLINK_CLEAR_DRAMA_LIST_IS_NULL = 23101503;
    public static final int ERROR_CODE_BDLINK_CLEAR_DRAMA_NO_RESPONSE = 23101501;
    public static final int ERROR_CODE_BDLINK_DANMAKU_INVALID_INFO = 23100802;
    public static final int ERROR_CODE_BDLINK_DANMAKU_NO_RESPONSE = 23100801;
    public static final int ERROR_CODE_BDLINK_DANMAKU_NULL_SINK_LISTENER = 23100803;
    public static final int ERROR_CODE_BDLINK_DRAMA_LIST_INVALID_INFO = 23101102;
    public static final int ERROR_CODE_BDLINK_DRAMA_LIST_NOT_SUPPORT = 23101105;
    public static final int ERROR_CODE_BDLINK_DRAMA_LIST_NO_RESPONSE = 23101101;
    public static final int ERROR_CODE_BDLINK_PAUSE_INVALID_INFO = 23100102;
    public static final int ERROR_CODE_BDLINK_PAUSE_NO_RESPONSE = 23100101;
    public static final int ERROR_CODE_BDLINK_PLAY_DRAMA_ID_ID_IS_NULL = 23101204;
    public static final int ERROR_CODE_BDLINK_PLAY_DRAMA_ID_INVALID_INFO = 23101202;
    public static final int ERROR_CODE_BDLINK_PLAY_DRAMA_ID_LIST_IS_NULL = 23101203;
    public static final int ERROR_CODE_BDLINK_PLAY_DRAMA_ID_NO_RESPONSE = 23101201;
    public static final int ERROR_CODE_BDLINK_PLAY_DRAMA_LIST_ID_IS_NULL = 23101104;
    public static final int ERROR_CODE_BDLINK_PLAY_DRAMA_LIST_LIST_IS_NULL = 23101103;
    public static final int ERROR_CODE_BDLINK_PLAY_INVALID_INFO = 23100002;
    public static final int ERROR_CODE_BDLINK_PLAY_NEXT_DRAMA_ID_IS_NULL = 23101404;
    public static final int ERROR_CODE_BDLINK_PLAY_NEXT_DRAMA_INVALID_INFO = 23101402;
    public static final int ERROR_CODE_BDLINK_PLAY_NEXT_DRAMA_LIST_IS_NULL = 23101403;
    public static final int ERROR_CODE_BDLINK_PLAY_NEXT_DRAMA_NO_RESPONSE = 23101401;
    public static final int ERROR_CODE_BDLINK_PLAY_NO_MEDIA_PRESENT = 23100003;
    public static final int ERROR_CODE_BDLINK_PLAY_NO_RESPONSE = 23100001;
    public static final int ERROR_CODE_BDLINK_PLAY_PRE_DRAMA_ID_IS_NULL = 23101304;
    public static final int ERROR_CODE_BDLINK_PLAY_PRE_DRAMA_INVALID_INFO = 23101302;
    public static final int ERROR_CODE_BDLINK_PLAY_PRE_DRAMA_LIST_IS_NULL = 23101303;
    public static final int ERROR_CODE_BDLINK_PLAY_PRE_DRAMA_NO_RESPONSE = 23101301;
    public static final int ERROR_CODE_BDLINK_QUERY_NO_RESPONSE = 23100701;
    public static final int ERROR_CODE_BDLINK_RESOLUTION_INVALID_INFO = 23100902;
    public static final int ERROR_CODE_BDLINK_RESOLUTION_NO_RESPONSE = 23100901;
    public static final int ERROR_CODE_BDLINK_RESOLUTION_NULL_SINK_LISTENER = 23100903;
    public static final int ERROR_CODE_BDLINK_RESUME_INVALID_INFO = 23100202;
    public static final int ERROR_CODE_BDLINK_RESUME_NO_RESPONSE = 23100201;
    public static final int ERROR_CODE_BDLINK_SEEK_INVALID_INFO = 23100302;
    public static final int ERROR_CODE_BDLINK_SEEK_NO_RESPONSE = 23100301;
    public static final int ERROR_CODE_BDLINK_SET_VOLUME_INVALID_INFO = 23100602;
    public static final int ERROR_CODE_BDLINK_SET_VOLUME_NO_RESPONSE = 23100601;
    public static final int ERROR_CODE_BDLINK_SPEED_INVALID_INFO = 23101002;
    public static final int ERROR_CODE_BDLINK_SPEED_NO_RESPONSE = 23101001;
    public static final int ERROR_CODE_BDLINK_SPEED_NULL_SINK_LISTENER = 23101003;
    public static final int ERROR_CODE_BDLINK_SUB_VOLUME_INVALID_INFO = 23100502;
    public static final int ERROR_CODE_BDLINK_SUB_VOLUME_NO_RESPONSE = 23100501;
    public static final int ERROR_CODE_CLOUDLINK_ADD_VOLUME_INVALID_INFO = 25100402;
    public static final int ERROR_CODE_CLOUDLINK_ADD_VOLUME_NOT_RESPONSED = 25100401;
    public static final int ERROR_CODE_CLOUDLINK_DANMAKU_INVALID_INFO = 25100802;
    public static final int ERROR_CODE_CLOUDLINK_DANMAKU_NOT_RESPONSED = 25100801;
    public static final int ERROR_CODE_CLOUDLINK_DANMAKU_NULL_SINK_LISTENER = 25100803;
    public static final int ERROR_CODE_CLOUDLINK_PAUSE_INVALID_INFO = 25100102;
    public static final int ERROR_CODE_CLOUDLINK_PAUSE_NOT_RESPONSED = 25100101;
    public static final int ERROR_CODE_CLOUDLINK_PLAY_INVALID_INFO = 25100002;
    public static final int ERROR_CODE_CLOUDLINK_PLAY_NON_MEDIA = 25100003;
    public static final int ERROR_CODE_CLOUDLINK_PLAY_NOT_RESPONSED = 25100001;
    public static final int ERROR_CODE_CLOUDLINK_QUERY_NOT_RESPONSED = 25100701;
    public static final int ERROR_CODE_CLOUDLINK_RESOLUTION_INVALID_INFO = 25100902;
    public static final int ERROR_CODE_CLOUDLINK_RESOLUTION_NOT_RESPONSED = 25100901;
    public static final int ERROR_CODE_CLOUDLINK_RESOLUTION_NULL_SINK_LISTENER = 25100903;
    public static final int ERROR_CODE_CLOUDLINK_RESUME_INVALID_INFO = 25100202;
    public static final int ERROR_CODE_CLOUDLINK_RESUME_NOT_RESPONSED = 25100201;
    public static final int ERROR_CODE_CLOUDLINK_SEEK_INVALID_INFO = 25100302;
    public static final int ERROR_CODE_CLOUDLINK_SEEK_NOT_RESPONSED = 25100301;
    public static final int ERROR_CODE_CLOUDLINK_SET_VOLUME_INVALID_INFO = 25100602;
    public static final int ERROR_CODE_CLOUDLINK_SET_VOLUME_NOT_RESPONSED = 25100601;
    public static final int ERROR_CODE_CLOUDLINK_SPEED_INVALID_INFO = 25101002;
    public static final int ERROR_CODE_CLOUDLINK_SPEED_NOT_RESPONSED = 25101001;
    public static final int ERROR_CODE_CLOUDLINK_SPEED_NULL_SINK_LISTENER = 25101003;
    public static final int ERROR_CODE_CLOUDLINK_SUB_VOLUME_INVALID_INFO = 25100502;
    public static final int ERROR_CODE_CLOUDLINK_SUB_VOLUME_NOT_RESPONSED = 25100501;
    public static final int ERROR_CODE_GOOGLECAST_ADD_VOLUME_INVALID_INFO = 26400402;
    public static final int ERROR_CODE_GOOGLECAST_ADD_VOLUME_NOT_RESPONSED = 26400401;
    public static final int ERROR_CODE_GOOGLECAST_DANMAKU_INVALID_INFO = 26400802;
    public static final int ERROR_CODE_GOOGLECAST_DANMAKU_NOT_RESPONSED = 26400801;
    public static final int ERROR_CODE_GOOGLECAST_DANMAKU_NULL_SINK_LISTENER = 26400803;
    public static final int ERROR_CODE_GOOGLECAST_PAUSE_INVALID_INFO = 26400102;
    public static final int ERROR_CODE_GOOGLECAST_PAUSE_NOT_RESPONSED = 26400101;
    public static final int ERROR_CODE_GOOGLECAST_PLAY_INVALID_INFO = 26400002;
    public static final int ERROR_CODE_GOOGLECAST_PLAY_NON_MEDIA = 26400003;
    public static final int ERROR_CODE_GOOGLECAST_PLAY_NOT_RESPONSED = 26400001;
    public static final int ERROR_CODE_GOOGLECAST_QUERY_NOT_RESPONSED = 26400701;
    public static final int ERROR_CODE_GOOGLECAST_RESOLUTION_INVALID_INFO = 26400902;
    public static final int ERROR_CODE_GOOGLECAST_RESOLUTION_NOT_RESPONSED = 26400901;
    public static final int ERROR_CODE_GOOGLECAST_RESOLUTION_NULL_SINK_LISTENER = 26400903;
    public static final int ERROR_CODE_GOOGLECAST_RESUME_INVALID_INFO = 26400202;
    public static final int ERROR_CODE_GOOGLECAST_RESUME_NOT_RESPONSED = 26400201;
    public static final int ERROR_CODE_GOOGLECAST_SEEK_INVALID_INFO = 26400302;
    public static final int ERROR_CODE_GOOGLECAST_SEEK_NOT_RESPONSED = 26400301;
    public static final int ERROR_CODE_GOOGLECAST_SET_VOLUME_INVALID_INFO = 26400602;
    public static final int ERROR_CODE_GOOGLECAST_SET_VOLUME_NOT_RESPONSED = 26400601;
    public static final int ERROR_CODE_GOOGLECAST_SPEED_INVALID_INFO = 26401002;
    public static final int ERROR_CODE_GOOGLECAST_SPEED_NOT_RESPONSED = 26401001;
    public static final int ERROR_CODE_GOOGLECAST_SPEED_NULL_SINK_LISTENER = 26401003;
    public static final int ERROR_CODE_GOOGLECAST_SUB_VOLUME_INVALID_INFO = 26400502;
    public static final int ERROR_CODE_GOOGLECAST_SUB_VOLUME_NOT_RESPONSED = 26400501;
    public static final int ERROR_CODE_SMARTVIEW_ADD_VOLUME_INVALID_INFO = 29100402;
    public static final int ERROR_CODE_SMARTVIEW_ADD_VOLUME_NO_RESPONSE = 29100401;
    public static final int ERROR_CODE_SMARTVIEW_CLEAR_DRAMA_ID_IS_NULL = 29101504;
    public static final int ERROR_CODE_SMARTVIEW_CLEAR_DRAMA_INVALID_INFO = 29101502;
    public static final int ERROR_CODE_SMARTVIEW_CLEAR_DRAMA_LIST_IS_NULL = 29101503;
    public static final int ERROR_CODE_SMARTVIEW_CLEAR_DRAMA_NO_RESPONSE = 29101501;
    public static final int ERROR_CODE_SMARTVIEW_DANMAKU_INVALID_INFO = 29100802;
    public static final int ERROR_CODE_SMARTVIEW_DANMAKU_NO_RESPONSE = 29100801;
    public static final int ERROR_CODE_SMARTVIEW_DANMAKU_NULL_SINK_LISTENER = 29100803;
    public static final int ERROR_CODE_SMARTVIEW_DRAMA_LIST_INVALID_INFO = 29101102;
    public static final int ERROR_CODE_SMARTVIEW_DRAMA_LIST_NOT_SUPPORT = 29101105;
    public static final int ERROR_CODE_SMARTVIEW_DRAMA_LIST_NO_RESPONSE = 29101101;
    public static final int ERROR_CODE_SMARTVIEW_PAUSE_INVALID_INFO = 29100102;
    public static final int ERROR_CODE_SMARTVIEW_PAUSE_NO_RESPONSE = 29100101;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_DRAMA_ID_ID_IS_NULL = 29101204;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_DRAMA_ID_INVALID_INFO = 29101202;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_DRAMA_ID_LIST_IS_NULL = 29101203;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_DRAMA_ID_NO_RESPONSE = 29101201;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_DRAMA_LIST_ID_IS_NULL = 29101104;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_DRAMA_LIST_LIST_IS_NULL = 29101103;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_INVALID_INFO = 29100002;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_NEXT_DRAMA_ID_IS_NULL = 29101404;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_NEXT_DRAMA_INVALID_INFO = 29101402;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_NEXT_DRAMA_LIST_IS_NULL = 29101403;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_NEXT_DRAMA_NO_RESPONSE = 29101401;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_NO_MEDIA_PRESENT = 29100003;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_NO_RESPONSE = 29100001;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_PRE_DRAMA_ID_IS_NULL = 29101304;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_PRE_DRAMA_INVALID_INFO = 29101302;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_PRE_DRAMA_LIST_IS_NULL = 29101303;
    public static final int ERROR_CODE_SMARTVIEW_PLAY_PRE_DRAMA_NO_RESPONSE = 29101301;
    public static final int ERROR_CODE_SMARTVIEW_QUERY_NO_RESPONSE = 29100701;
    public static final int ERROR_CODE_SMARTVIEW_RESOLUTION_INVALID_INFO = 29100902;
    public static final int ERROR_CODE_SMARTVIEW_RESOLUTION_NO_RESPONSE = 29100901;
    public static final int ERROR_CODE_SMARTVIEW_RESOLUTION_NULL_SINK_LISTENER = 29100903;
    public static final int ERROR_CODE_SMARTVIEW_RESUME_INVALID_INFO = 29100202;
    public static final int ERROR_CODE_SMARTVIEW_RESUME_NO_RESPONSE = 29100201;
    public static final int ERROR_CODE_SMARTVIEW_SEEK_INVALID_INFO = 29100302;
    public static final int ERROR_CODE_SMARTVIEW_SEEK_NO_RESPONSE = 29100301;
    public static final int ERROR_CODE_SMARTVIEW_SET_VOLUME_INVALID_INFO = 29100602;
    public static final int ERROR_CODE_SMARTVIEW_SET_VOLUME_NO_RESPONSE = 29100601;
    public static final int ERROR_CODE_SMARTVIEW_SPEED_INVALID_INFO = 29101002;
    public static final int ERROR_CODE_SMARTVIEW_SPEED_NO_RESPONSE = 29101001;
    public static final int ERROR_CODE_SMARTVIEW_SPEED_NULL_SINK_LISTENER = 29101003;
    public static final int ERROR_CODE_SMARTVIEW_SUB_VOLUME_INVALID_INFO = 29100502;
    public static final int ERROR_CODE_SMARTVIEW_SUB_VOLUME_NO_RESPONSE = 29100501;
    public static final String ERROR_MSG_BDDLNA_AVTRANS_SERVICE_NOT_EXIST = "BDDLNA failed due to AVTransport service is not in service list";
    public static final String ERROR_MSG_BDDLNA_AVTRANS_SERVICE_NOT_EXIST_2 = "BDDLNA failed due to AVTransport service is not in device list";
    public static final String ERROR_MSG_BDDLNA_AVTRANS_SERVICE_NOT_EXIST_3 = "BDDLNA failed due to AVTransport service is not in service and device list";
    public static final String ERROR_MSG_BDDLNA_CUSTOMIZED_CONSTRUCT_JSON = "BDDLNA customized, failed due to construct json";
    public static final String ERROR_MSG_BDDLNA_CUSTOMIZED_INVALID_REPSONSE = "BDDLNA customized, failed due to empty reponse or empty body";
    public static final String ERROR_MSG_BDDLNA_CUSTOMIZED_NON_DEVICE = "BDDLNA customized, failed due to no device";
    public static final String ERROR_MSG_BDDLNA_CUSTOMIZED_NON_PLAYERI_INFO = "BDDLNA customized, failed due to non playerInfo";
    public static final String ERROR_MSG_BDDLNA_CUSTOMIZED_PARSE_RESPONSE = "BDDLNA customized, failed due to exception occurs while parse response body";
    public static final String ERROR_MSG_BDDLNA_INVALID_PLAYER_INFO = "BDDLNA failed due to null url in player info";
    public static final String ERROR_MSG_BDDLNA_INVALID_PLAY_INFO = "BDDLNA failed due to null url in play info";
    public static final String ERROR_MSG_BDDLNA_INVALID_RESPONSE_STATUS = "BDDLNA failed due to invalid status with response from server";
    public static final String ERROR_MSG_BDDLNA_NO_DEVICE = "BDDLNA failed due to no device";
    public static final String ERROR_MSG_BDDLNA_NULL_ACTION_LIST = "BDDLNA failed due to null action list";
    public static final String ERROR_MSG_BDDLNA_NULL_AVTRANS_SERVICE = "BDDLNA failed due to null AVTransport service";
    public static final String ERROR_MSG_BDDLNA_NULL_PLAY_ACTION = "BDDLNA failed due to null play action";
    public static final String ERROR_MSG_BDDLNA_NULL_SCPD = "BDDLNA failed due to null scpd";
    public static final String ERROR_MSG_BDDLNA_NULL_SETAVTRANS_ACTION = "BDDLNA failed due to null SetAVTransportURI action";
    public static final String ERROR_MSG_BDDLNA_NULL_STATUS = "BDDLNA failed due to null status";
    public static final String ERROR_MSG_BDDLNA_PARSE_EXCEPTION = "BDDLNA failed due to parse http stream exception";
    public static final String ERROR_MSG_BDDLNA_PLAY_IO_EXCEPTION = "BDDLNA play failed due to io exception";
    public static final String ERROR_MSG_BDDLNA_PLAY_SOCKET_EXCEPTION = "BDDLNA play failed due to socket exception";
    public static final String ERROR_MSG_BDDLNA_PLAY_SOCKET_TIMEOUT = "BDDLNA play failed due to socket timeout";
    public static final String ERROR_MSG_BDLINK_ADD_VOLUME_INVALID_INFO = "BDLink add volume error invalid info";
    public static final String ERROR_MSG_BDLINK_ADD_VOLUME_NO_RESPONSE = "BDLink add volume error no response";
    public static final String ERROR_MSG_BDLINK_CLEAR_DRAMA_ID_IS_NULL = "BDLink clear drama error id is null";
    public static final String ERROR_MSG_BDLINK_CLEAR_DRAMA_INVALID_INFO = "BDLink clear drama error invalid info";
    public static final String ERROR_MSG_BDLINK_CLEAR_DRAMA_LIST_IS_NULL = "BDLink clear drama error list is null";
    public static final String ERROR_MSG_BDLINK_CLEAR_DRAMA_NO_RESPONSE = "BDLink clear drama error no response";
    public static final String ERROR_MSG_BDLINK_DANMAKU_INVALID_INFO = "BDLink danmaku error invalid info";
    public static final String ERROR_MSG_BDLINK_DANMAKU_NO_RESPONSE = "BDLink danmaku error no response";
    public static final String ERROR_MSG_BDLINK_DANMAKU_NULL_SINK_LISTENER = "BDLink danmaku error sink listener is null";
    public static final String ERROR_MSG_BDLINK_DRAMA_LIST_INVALID_INFO = "BDLink play drama list error invalid info";
    public static final String ERROR_MSG_BDLINK_DRAMA_LIST_NOT_SUPPORT = "BDLink play drama list error not support";
    public static final String ERROR_MSG_BDLINK_DRAMA_LIST_NO_RESPONSE = "BDLink play drama list error no response";
    public static final String ERROR_MSG_BDLINK_PAUSE_INVALID_INFO = "BDLink pause error invalid info";
    public static final String ERROR_MSG_BDLINK_PAUSE_NO_RESPONSE = "BDLink pause error no response";
    public static final String ERROR_MSG_BDLINK_PLAY_DRAMA_ID_ID_IS_NULL = "BDLink play drama id error id is null";
    public static final String ERROR_MSG_BDLINK_PLAY_DRAMA_ID_INVALID_INFO = "BDLink play drama id error invalid info";
    public static final String ERROR_MSG_BDLINK_PLAY_DRAMA_ID_LIST_IS_NULL = "BDLink play drama id error list is null";
    public static final String ERROR_MSG_BDLINK_PLAY_DRAMA_ID_NO_RESPONSE = "BDLink play drama id error no response";
    public static final String ERROR_MSG_BDLINK_PLAY_DRAMA_LIST_ID_IS_NULL = "BDLink play drama list error id is null";
    public static final String ERROR_MSG_BDLINK_PLAY_DRAMA_LIST_LIST_IS_NULL = "BDLink play drama list error list is null";
    public static final String ERROR_MSG_BDLINK_PLAY_INVALID_INFO = "BDLink play error invalid info";
    public static final String ERROR_MSG_BDLINK_PLAY_NEXT_DRAMA_ID_IS_NULL = "BDLink play next drama error id is null";
    public static final String ERROR_MSG_BDLINK_PLAY_NEXT_DRAMA_INVALID_INFO = "BDLink play next drama error invalid info";
    public static final String ERROR_MSG_BDLINK_PLAY_NEXT_DRAMA_LIST_IS_NULL = "BDLink play next drama error list is null";
    public static final String ERROR_MSG_BDLINK_PLAY_NEXT_DRAMA_NO_RESPONSE = "BDLink play next drama error no response";
    public static final String ERROR_MSG_BDLINK_PLAY_NO_MEDIA_PRESENT = "BDLink play error no media present";
    public static final String ERROR_MSG_BDLINK_PLAY_NO_RESPONSE = "BDLink play error no response";
    public static final String ERROR_MSG_BDLINK_PLAY_PRE_DRAMA_ID_IS_NULL = "BDLink play pre drama error id is null";
    public static final String ERROR_MSG_BDLINK_PLAY_PRE_DRAMA_INVALID_INFO = "BDLink play pre drama error invalid info";
    public static final String ERROR_MSG_BDLINK_PLAY_PRE_DRAMA_LIST_IS_NULL = "BDLink play pre drama error list is null";
    public static final String ERROR_MSG_BDLINK_PLAY_PRE_DRAMA_NO_RESPONSE = "BDLink play pre drama error no response";
    public static final String ERROR_MSG_BDLINK_QUERY_NO_RESPONSE = "BDLink query error no response";
    public static final String ERROR_MSG_BDLINK_RESOLUTION_INVALID_INFO = "BDLink resolution error invalid info";
    public static final String ERROR_MSG_BDLINK_RESOLUTION_NO_RESPONSE = "BDLink resolution error no response";
    public static final String ERROR_MSG_BDLINK_RESOLUTION_NULL_SINK_LISTENER = "BDLink resolution error sink listener is null";
    public static final String ERROR_MSG_BDLINK_RESUME_INVALID_INFO = "BDLink resume error invalid info";
    public static final String ERROR_MSG_BDLINK_RESUME_NO_RESPONSE = "BDLink resume error no response";
    public static final String ERROR_MSG_BDLINK_SEEK_INVALID_INFO = "BDLink seek error invalid info";
    public static final String ERROR_MSG_BDLINK_SEEK_NO_RESPONSE = "BDLink seek error no response";
    public static final String ERROR_MSG_BDLINK_SET_VOLUME_INVALID_INFO = "BDLink set volume error invalid info";
    public static final String ERROR_MSG_BDLINK_SET_VOLUME_NO_RESPONSE = "BDLink set volume error no response";
    public static final String ERROR_MSG_BDLINK_SPEED_INVALID_INFO = "BDLink speed error invalid info";
    public static final String ERROR_MSG_BDLINK_SPEED_NO_RESPONSE = "BDLink speed error no response";
    public static final String ERROR_MSG_BDLINK_SPEED_NULL_SINK_LISTENER = "BDLink speed error sink listener is null";
    public static final String ERROR_MSG_BDLINK_SUB_VOLUME_INVALID_INFO = "BDLink sub volume error no response";
    public static final String ERROR_MSG_BDLINK_SUB_VOLUME_NO_RESPONSE = "BDLink sub volume error no response";
    public static final String ERROR_MSG_CLOUDLINK_ADD_VOLUME_INVALID_INFO = "CloudLink add volume error invalid info";
    public static final String ERROR_MSG_CLOUDLINK_ADD_VOLUME_NOT_RESPONSED = "CloudLink add volume error no response";
    public static final String ERROR_MSG_CLOUDLINK_DANMAKU_INVALID_INFO = "CloudLink danmaku error invalid info";
    public static final String ERROR_MSG_CLOUDLINK_DANMAKU_NOT_RESPONSED = "CloudLink danmaku error no response";
    public static final String ERROR_MSG_CLOUDLINK_DANMAKU_NULL_SINK_LISTENER = "CloudLink danmaku error sink listener is null";
    public static final String ERROR_MSG_CLOUDLINK_PAUSE_INVALID_INFO = "CloudLink pause error invalid info";
    public static final String ERROR_MSG_CLOUDLINK_PAUSE_NOT_RESPONSED = "CloudLink pause error no response";
    public static final String ERROR_MSG_CLOUDLINK_PLAY_INVALID_INFO = "CloudLink play error invalid info";
    public static final String ERROR_MSG_CLOUDLINK_PLAY_NON_MEDIA = "CloudLink play error no media present";
    public static final String ERROR_MSG_CLOUDLINK_PLAY_NOT_RESPONSED = "CloudLink play error no response";
    public static final String ERROR_MSG_CLOUDLINK_QUERY_NOT_RESPONSED = "CloudLink query error no response";
    public static final String ERROR_MSG_CLOUDLINK_RESOLUTION_INVALID_INFO = "CloudLink resolution error invalid info";
    public static final String ERROR_MSG_CLOUDLINK_RESOLUTION_NOT_RESPONSED = "CloudLink resolution error no response";
    public static final String ERROR_MSG_CLOUDLINK_RESOLUTION_NULL_SINK_LISTENER = "CloudLink resolution error sink listener is null";
    public static final String ERROR_MSG_CLOUDLINK_RESUME_INVALID_INFO = "CloudLink resume error invalid info";
    public static final String ERROR_MSG_CLOUDLINK_RESUME_NOT_RESPONSED = "CloudLink resume error no response";
    public static final String ERROR_MSG_CLOUDLINK_SEEK_INVALID_INFO = "CloudLink seek error invalid info";
    public static final String ERROR_MSG_CLOUDLINK_SEEK_NOT_RESPONSED = "CloudLink seek error no response";
    public static final String ERROR_MSG_CLOUDLINK_SET_VOLUME_INVALID_INFO = "CloudLink set volume error invalid info";
    public static final String ERROR_MSG_CLOUDLINK_SET_VOLUME_NOT_RESPONSED = "CloudLink set volume error no response";
    public static final String ERROR_MSG_CLOUDLINK_SPEED_INVALID_INFO = "CloudLink speed error invalid info";
    public static final String ERROR_MSG_CLOUDLINK_SPEED_NOT_RESPONSED = "CloudLink speed error no response";
    public static final String ERROR_MSG_CLOUDLINK_SPEED_NULL_SINK_LISTENER = "CloudLink speed error sink listener is null";
    public static final String ERROR_MSG_CLOUDLINK_SUB_VOLUME_INVALID_INFO = "CloudLink sub volume error invalid info";
    public static final String ERROR_MSG_CLOUDLINK_SUB_VOLUME_NOT_RESPONSED = "CloudLink sub volume error no response";
    public static final String ERROR_MSG_GOOGLECAST_ADD_VOLUME_INVALID_INFO = "GoogleCast add volume error invalid info";
    public static final String ERROR_MSG_GOOGLECAST_ADD_VOLUME_NOT_RESPONSED = "GoogleCast add volume error no response";
    public static final String ERROR_MSG_GOOGLECAST_DANMAKU_INVALID_INFO = "GoogleCast danmaku error invalid info";
    public static final String ERROR_MSG_GOOGLECAST_DANMAKU_NOT_RESPONSED = "GoogleCast danmaku error no response";
    public static final String ERROR_MSG_GOOGLECAST_DANMAKU_NULL_SINK_LISTENER = "GoogleCast danmaku error sink listener is null";
    public static final String ERROR_MSG_GOOGLECAST_PAUSE_INVALID_INFO = "GoogleCast pause error invalid info";
    public static final String ERROR_MSG_GOOGLECAST_PAUSE_NOT_RESPONSED = "GoogleCast pause error no response";
    public static final String ERROR_MSG_GOOGLECAST_PLAY_INVALID_INFO = "GoogleCast play error invalid info";
    public static final String ERROR_MSG_GOOGLECAST_PLAY_NON_MEDIA = "GoogleCast play error no media present";
    public static final String ERROR_MSG_GOOGLECAST_PLAY_NOT_RESPONSED = "GoogleCast play error no response";
    public static final String ERROR_MSG_GOOGLECAST_QUERY_NOT_RESPONSED = "GoogleCast query error no response";
    public static final String ERROR_MSG_GOOGLECAST_RESOLUTION_INVALID_INFO = "GoogleCast resolution error invalid info";
    public static final String ERROR_MSG_GOOGLECAST_RESOLUTION_NOT_RESPONSED = "GoogleCast resolution error no response";
    public static final String ERROR_MSG_GOOGLECAST_RESOLUTION_NULL_SINK_LISTENER = "GoogleCast resolution error sink listener is null";
    public static final String ERROR_MSG_GOOGLECAST_RESUME_INVALID_INFO = "GoogleCast resume error invalid info";
    public static final String ERROR_MSG_GOOGLECAST_RESUME_NOT_RESPONSED = "GoogleCast resume error no response";
    public static final String ERROR_MSG_GOOGLECAST_SEEK_INVALID_INFO = "GoogleCast seek error invalid info";
    public static final String ERROR_MSG_GOOGLECAST_SEEK_NOT_RESPONSED = "GoogleCast seek error no response";
    public static final String ERROR_MSG_GOOGLECAST_SET_VOLUME_INVALID_INFO = "GoogleCast set volume error invalid info";
    public static final String ERROR_MSG_GOOGLECAST_SET_VOLUME_NOT_RESPONSED = "GoogleCast set volume error no response";
    public static final String ERROR_MSG_GOOGLECAST_SPEED_INVALID_INFO = "GoogleCast speed error invalid info";
    public static final String ERROR_MSG_GOOGLECAST_SPEED_NOT_RESPONSED = "GoogleCast speed error no response";
    public static final String ERROR_MSG_GOOGLECAST_SPEED_NULL_SINK_LISTENER = "GoogleCast speed error sink listener is null";
    public static final String ERROR_MSG_GOOGLECAST_SUB_VOLUME_INVALID_INFO = "GoogleCast sub volume error invalid info";
    public static final String ERROR_MSG_GOOGLECAST_SUB_VOLUME_NOT_RESPONSED = "GoogleCast sub volume error no response";
    public static final String ERROR_MSG_SMARTVIEW_ADD_VOLUME_INVALID_INFO = "SmartView add volume error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_ADD_VOLUME_NO_RESPONSE = "SmartView add volume error no response";
    public static final String ERROR_MSG_SMARTVIEW_CLEAR_DRAMA_ID_IS_NULL = "SmartView clear drama error id is null";
    public static final String ERROR_MSG_SMARTVIEW_CLEAR_DRAMA_INVALID_INFO = "SmartView clear drama error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_CLEAR_DRAMA_LIST_IS_NULL = "SmartView clear drama error list is null";
    public static final String ERROR_MSG_SMARTVIEW_CLEAR_DRAMA_NO_RESPONSE = "SmartView clear drama error no response";
    public static final String ERROR_MSG_SMARTVIEW_DANMAKU_INVALID_INFO = "SmartView danmaku error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_DANMAKU_NO_RESPONSE = "SmartView danmaku error no response";
    public static final String ERROR_MSG_SMARTVIEW_DANMAKU_NULL_SINK_LISTENER = "SmartView danmaku error sink listener is null";
    public static final String ERROR_MSG_SMARTVIEW_DRAMA_LIST_INVALID_INFO = "SmartView play drama list error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_DRAMA_LIST_NOT_SUPPORT = "SmartView play drama list error not support";
    public static final String ERROR_MSG_SMARTVIEW_DRAMA_LIST_NO_RESPONSE = "SmartView play drama list error no response";
    public static final String ERROR_MSG_SMARTVIEW_PAUSE_INVALID_INFO = "SmartView pause error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_PAUSE_NO_RESPONSE = "SmartView pause error no response";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_DRAMA_ID_ID_IS_NULL = "SmartView play drama id error id is null";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_DRAMA_ID_INVALID_INFO = "SmartView play drama id error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_DRAMA_ID_LIST_IS_NULL = "SmartView play drama id error list is null";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_DRAMA_ID_NO_RESPONSE = "SmartView play drama id error no response";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_DRAMA_LIST_ID_IS_NULL = "SmartView play drama list error id is null";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_DRAMA_LIST_LIST_IS_NULL = "SmartView play drama list error list is null";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_INVALID_INFO = "SmartView play error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_NEXT_DRAMA_ID_IS_NULL = "SmartView play next drama error id is null";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_NEXT_DRAMA_INVALID_INFO = "SmartView play next drama error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_NEXT_DRAMA_LIST_IS_NULL = "SmartView play next drama error list is null";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_NEXT_DRAMA_NO_RESPONSE = "SmartView play next drama error no response";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_NO_MEDIA_PRESENT = "SmartView play error no media present";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_NO_RESPONSE = "SmartView play error no response";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_PRE_DRAMA_ID_IS_NULL = "SmartView play pre drama error id is null";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_PRE_DRAMA_INVALID_INFO = "SmartView play pre drama error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_PRE_DRAMA_LIST_IS_NULL = "SmartView play pre drama error list is null";
    public static final String ERROR_MSG_SMARTVIEW_PLAY_PRE_DRAMA_NO_RESPONSE = "SmartView play pre drama error no response";
    public static final String ERROR_MSG_SMARTVIEW_QUERY_NO_RESPONSE = "SmartView query error no response";
    public static final String ERROR_MSG_SMARTVIEW_RESOLUTION_INVALID_INFO = "SmartView resolution error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_RESOLUTION_NO_RESPONSE = "SmartView resolution error no response";
    public static final String ERROR_MSG_SMARTVIEW_RESOLUTION_NULL_SINK_LISTENER = "SmartView resolution error sink listener is null";
    public static final String ERROR_MSG_SMARTVIEW_RESUME_INVALID_INFO = "SmartView resume error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_RESUME_NO_RESPONSE = "SmartView resume error no response";
    public static final String ERROR_MSG_SMARTVIEW_SEEK_INVALID_INFO = "SmartView seek error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_SEEK_NO_RESPONSE = "SmartView seek error no response";
    public static final String ERROR_MSG_SMARTVIEW_SET_VOLUME_INVALID_INFO = "SmartView set volume error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_SET_VOLUME_NO_RESPONSE = "SmartView set volume error no response";
    public static final String ERROR_MSG_SMARTVIEW_SPEED_INVALID_INFO = "SmartView speed error invalid info";
    public static final String ERROR_MSG_SMARTVIEW_SPEED_NO_RESPONSE = "SmartView speed error no response";
    public static final String ERROR_MSG_SMARTVIEW_SPEED_NULL_SINK_LISTENER = "SmartView speed error sink listener is null";
    public static final String ERROR_MSG_SMARTVIEW_SUB_VOLUME_INVALID_INFO = "SmartView sub volume error no response";
    public static final String ERROR_MSG_SMARTVIEW_SUB_VOLUME_NO_RESPONSE = "SmartView sub volume error no response";

    /* JADX INFO: renamed from: com.byted.cast.common.source.IPlayerListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onDisconnect(IPlayerListener r100) {
        }

        public static void $default$onError(IPlayerListener r100, int r101, int r102) {
        }

        public static void $default$onError(IPlayerListener r100, int r101, String r102) {
        }

        public static void $default$onError(IPlayerListener r100, ServiceInfo r101, int r102, String r103) {
        }

        public static void $default$onInfo(IPlayerListener r100, int r101, int r102) {
        }

        public static void $default$onInfo(IPlayerListener r100, int r101, int r102, String r103) {
        }

        public static void $default$onPlayCommandSuccess(IPlayerListener r100) {
        }
    }

    void onCompletion();

    void onDisconnect();

    void onDramaId(ServiceInfo r100, String r101);

    void onDramaList(ServiceInfo r100, DramaBean[] r101);

    void onError(int r100, int r101);

    void onError(int r100, String r101);

    void onError(ServiceInfo r100, int r101, String r102);

    void onInfo(int r100, int r101);

    void onInfo(int r100, int r101, String r102);

    void onLoading();

    void onPause();

    void onPlayCommandSuccess();

    void onPositionUpdate(long r100, long r101);

    void onSeekComplete(long r100);

    void onStart();

    void onStop();

    void onVolumeChanged(float r100);
}
