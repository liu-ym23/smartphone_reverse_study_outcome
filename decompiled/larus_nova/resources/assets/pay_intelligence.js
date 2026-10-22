function parseJsonStringToArray(e){try{var t=JSON.parse(e)
if(Array.isArray(t))return t
throw new Error("Parsed JSON is not an array")}catch(e){return null}}var dataHandlerModule={onTrackEvent:function(e,t){retainDecisionModule&&retainDecisionModule.onTrackEvent(e,t)}},ntvModule=NativeModules.get("CJPayIntelligenceJsModule"),retainDecisionModule={concernedEvents:["wallet_rd_enter_doupay_process","wallet_exit_cashier_process","wallet_rd_exit_doupay_process","wallet_rd_default_method_changed","wallet_cashier_second_pay_page_click","wallet_cashier_right_click","wallet_cashier_more_method_click","wallet_cashier_right_button_show","wallet_password_verify_page_imp","wallet_sms_check_halfscreen_page_imp","wallet_new_bank_signup_imp","wallet_fingerprint_verify_page_imp","wallet_alivecheck_fullpage_imp","wallet_alivecheck_call","wallet_password_verify_page_verify_result","wallet_sms_check_halfscreen_result","wallet_new_bank_signup_result","wallet_fingerprint_verify_page_verify_result","wallet_alivecheck_result","wallet_password_verify_page_right_click","wallet_password_verify_page_first_input","wallet_password_verify_page_forget_click","wallet_modify_password_forget_click","wallet_password_verify_recommend_click","wallet_password_verify_page_click","wallet_cashier_choose_method_click","wallet_rd_yuefu_auth_expand","wallet_cashier_onesteppswd_pay_page_imp","wallet_fingerprint_verify_page_to_pwd"],onePayEventDatas:[],marketingRetainTypes:["retain_type_expand","retain_type_voucher","retain_type_verify","retain_type_no_pwd"],hasEventInOnePayDatas:function(e){return"string"==typeof e&&""!==e.trim()&&this.onePayEventDatas.some((([t])=>t===e))},getEventDatasByName:function(e){return this.onePayEventDatas.filter((function(t){return t[0]===e}))},verifyResult:function(e){for(let t=0;t<this.onePayEventDatas.length;t++){const i=this.onePayEventDatas[t]
if(i[0]===e){const e=i[1]&&i[1].result
if(1===e||"1"===e)return 1
if(0===e||"0"===e)return 0}}},checkedVerifyTypes:function(){const e=[]
return this.hasEventInOnePayDatas("wallet_password_verify_page_imp")&&e.push("retain_type_recommend_pwd"),(this.hasEventInOnePayDatas("wallet_sms_check_halfscreen_page_imp")||this.hasEventInOnePayDatas("wallet_new_bank_signup_imp"))&&e.push("retain_type_recommend_sms"),this.hasEventInOnePayDatas("wallet_fingerprint_verify_page_imp")&&(e.push("retain_type_recommend_finger"),e.push("retain_type_recommend_faceid")),(this.hasEventInOnePayDatas("wallet_alivecheck_fullpage_imp")||this.hasEventInOnePayDatas("wallet_alivecheck_call"))&&e.push("retain_type_recommend_face"),e},firstRetainTypeExcludeTypes:function(e,t){if(void 0!==e&&0!==e.length){if(void 0===t||0===t.length)return e[0]
for(let i=0;i<e.length;i++){let n=e[i]
if(!t.includes(n))return n}}},constructRetJsonStr:function(e,t,i,n){let a={}
if(a.scene=e,a.retain_type=t,a.rule_id=i,("retain_type_questionnaire"===t||"retain_type_life_promotion"===t)&&void 0!==n){const i=this.genRetainInfo(e,t,n)
void 0!==i&&(a.retain_info_data=i,"retain_type_life_promotion"===t&&(a.extra_data={params_for_special:"tppp",is_chaselight:"1",keep_pop_type:"shengfu_202508",business:"生服弹窗验证组件",pop_style:"retain_type_goods"}))}return JSON.stringify(a)},decideWndType:function(e){var t=void 0
try{t=JSON.parse(e)}catch(e){return""}if(void 0===t.input_pwd_retain_info||void 0===t.unput_pwd_retain_info||void 0===t.verify_retain_info||void 0===t.from_scene)return""
var i=t.from_scene
if("skip_pwd"!==i&&"verify_password"!==i){let e=[]
t.input_pwd_retain_info&&e.push(t.input_pwd_retain_info),t.unput_pwd_retain_info&&e.push(t.unput_pwd_retain_info),t.verify_retain_info&&e.push(t.verify_retain_info)
for(let t=0;t<e.length;t++){let i=e[t],n=i.indexOf("retain_type_balance");-1!==n&&i.splice(n,1)
let a=i.indexOf("retain_type_balance_combine");-1!==a&&i.splice(a,1)}}var n=retainDecisionModule
t.input_pwd_retain_info=n.getValidRetainInfo(t,"input_pwd_retain_info"),t.unput_pwd_retain_info=n.getValidRetainInfo(t,"unput_pwd_retain_info"),t.verify_retain_info=n.getValidRetainInfo(t,"verify_retain_info")
let a=[]
var r=n.hasEventInOnePayDatas("wallet_password_verify_page_imp"),_=n.hasEventInOnePayDatas("wallet_sms_check_halfscreen_page_imp")||n.hasEventInOnePayDatas("wallet_new_bank_signup_imp"),s=n.hasEventInOnePayDatas("wallet_fingerprint_verify_page_imp"),o=n.hasEventInOnePayDatas("wallet_alivecheck_fullpage_imp")||n.hasEventInOnePayDatas("wallet_alivecheck_call"),l=n.hasEventInOnePayDatas("wallet_cashier_onesteppswd_pay_page_imp")
r&&a.push("pwd"),_&&a.push("sms"),s&&a.push("finger"),o&&a.push("live"),l&&a.push("nopwd")
var c=(t=n.processRetainInfoBatchData(t,a)).retain_info_batch,u=n.hasEventInOnePayDatas("wallet_password_verify_page_first_input")
if("sms_verify"===i&&t.verify_retain_info.includes("retain_type_questionnaire"))return n.constructRetJsonStr("verify_retain_info","retain_type_questionnaire","0",c)
if(!0===u&&t.input_pwd_retain_info.includes("retain_type_questionnaire"))return n.constructRetJsonStr("input_pwd_retain_info","retain_type_questionnaire","0",c)
if(!1===u&&t.unput_pwd_retain_info.includes("retain_type_questionnaire"))return n.constructRetJsonStr("unput_pwd_retain_info","retain_type_questionnaire","0",c)
if("skip_pwd"===i){let e=t.unput_pwd_retain_info
return 0===e.length?"":n.constructRetJsonStr("unput_pwd_retain_info",e[0],"0",c)}if(n.hasEventInOnePayDatas("wallet_rd_yuefu_auth_expand")){let e="retain_type_default"
if(t.unput_pwd_retain_info.includes(e))return n.constructRetJsonStr("unput_pwd_retain_info",e,"0",c)}var d=n.hasEventInOnePayDatas("wallet_rd_default_method_changed")
if("bio_verify"===i||"face_verify"===i||"sms_verify"===i){let e=!1
if((r?1:0)+(_?1:0)+(s?1:0)+(o?1:0)>1){let t
"face_verify"===i?t=n.verifyResult("wallet_alivecheck_result"):(t=n.verifyResult("wallet_sms_check_halfscreen_result"),void 0===t&&(t=n.verifyResult("wallet_new_bank_signup_result"))),e=void 0===t}if(e){let e=t.verify_retain_info
if(0===e.length)return""
{let t=d?n.firstRetainTypeExcludeTypes(e,[...n.checkedVerifyTypes(),...n.marketingRetainTypes]):n.firstRetainTypeExcludeTypes(e,n.checkedVerifyTypes()),i=d?"1":"0"
return n.constructRetJsonStr("verify_retain_info",t,i,c)}}}var p=n.hasEventInOnePayDatas("wallet_password_verify_page_right_click"),f=n.hasEventInOnePayDatas("wallet_password_verify_page_forget_click")||n.hasEventInOnePayDatas("wallet_modify_password_forget_click")
let y,h=n.verifyResult("wallet_password_verify_page_verify_result"),g=n.verifyResult("wallet_fingerprint_verify_page_verify_result"),v=n.verifyResult("wallet_alivecheck_result")
1===n.verifyResult("wallet_sms_check_halfscreen_result")||1===n.verifyResult("wallet_new_bank_signup_result")?y=1:0!==n.verifyResult("wallet_sms_check_halfscreen_result")&&0!==n.verifyResult("wallet_new_bank_signup_result")||(y=0)
let w=0===h||f||u
var m="verify_pwd"===t.pwd_type
if("verify_password"===i&&w&&m){let e="retain_type_reset_pwd",i=u?t.input_pwd_retain_info:t.unput_pwd_retain_info,a=u?t.unput_pwd_retain_info:t.input_pwd_retain_info
if(i.includes(e))return n.constructRetJsonStr(u?"input_pwd_retain_info":"unput_pwd_retain_info",e,"0",c)
if(a.includes(e))return n.constructRetJsonStr(u?"unput_pwd_retain_info":"input_pwd_retain_info",e,"0",c)}var b=0===h||0===g||0===v||0===y
let k=b||p||f||u
if("1"===ntvModule.getABTestValAndExposure("cjpay_client_decision_algorithm_opt_7.3.7")&&(k=b||p||f),k)if("1"===ntvModule.getABTestValAndExposure("cjpay_client_decision_algorithm_bio_verify_opt_7.4.0")){let e=["retain_type_recommend_faceid","retain_type_recommend_finger","retain_type_recommend_face","retain_type_recommend_sms"],i=n.getEventDatasByName("wallet_password_verify_page_imp")
if(i.length>0){let t=i[0][1]
if(t.show_verify_type.includes("面容支付")||t.show_verify_type.includes("使用面容")){let t="retain_type_recomend_faceid",i=e.indexOf(t);-1!==i&&(e.splice(i,1),e.push(t))}if(t.show_verify_type.includes("指纹支付")||t.show_verify_type.includes("使用指纹")){let t="retain_type_recomend_finger",i=e.indexOf(t);-1!==i&&(e.splice(i,1),e.push(t))}if(t.show_verify_type.includes("刷脸支付")||t.show_verify_type.includes("使用刷脸")){let t="retain_type_recommend_face",i=e.indexOf(t);-1!==i&&(e.splice(i,1),e.push(t))}if(t.show_verify_type.includes("使用短信")||t.show_verify_type.includes("短信验证支付")){let t="retain_type_recommend_sms",i=e.indexOf(t);-1!==i&&(e.splice(i,1),e.push(t))}}let a="1"===t.is_bio_downgrade
if(n.hasEventInOnePayDatas("wallet_fingerprint_verify_page_imp")||a){let t=e.indexOf("retain_type_recomend_faceid");-1===t&&(t=e.indexOf("retain_type_recomend_finger")),-1!==t&&e.splice(t,1)}if(n.hasEventInOnePayDatas("wallet_alivecheck_fullpage_imp")||n.hasEventInOnePayDatas("wallet_alivecheck_call")){let t=e.indexOf("retain_type_recommend_face");-1!==t&&e.splice(t,1)}if(n.hasEventInOnePayDatas("wallet_sms_check_halfscreen_page_imp")||n.hasEventInOnePayDatas("wallet_new_bank_signup_imp")){let t=e.indexOf("retain_type_recommend_sms");-1!==t&&e.splice(t,1)}if(e.length>0){let i="0"
i=b?"2":p?"3":"4"
for(let a=0;a<e.length;a++){let r=e[a],_=u?t.input_pwd_retain_info:t.unput_pwd_retain_info,s=u?t.unput_pwd_retain_info:t.input_pwd_retain_info
if(_.includes(r))return n.constructRetJsonStr(u?"input_pwd_retain_info":"unput_pwd_retain_info",r,i,c)
if(s.includes(r))return n.constructRetJsonStr(u?"unput_pwd_retain_info":"input_pwd_retain_info",r,i,c)}}}else{let e=["retain_type_recommend_face","retain_type_recommend_sms"],i=n.getEventDatasByName("wallet_password_verify_page_imp")
if(i.length>0){let t=i[0][1]
if(t.show_verify_type.includes("刷脸支付")||t.show_verify_type.includes("使用刷脸")){let t="retain_type_recommend_face",i=e.indexOf(t);-1!==i&&(e.splice(i,1),e.push(t))}if(t.show_verify_type.includes("使用短信")||t.show_verify_type.includes("短信验证支付")){let t="retain_type_recommend_sms",i=e.indexOf(t);-1!==i&&(e.splice(i,1),e.push(t))}}if(n.hasEventInOnePayDatas("wallet_alivecheck_fullpage_imp")||n.hasEventInOnePayDatas("wallet_alivecheck_call")){let t=e.indexOf("retain_type_recommend_face");-1!==t&&e.splice(t,1)}if(n.hasEventInOnePayDatas("wallet_sms_check_halfscreen_page_imp")||n.hasEventInOnePayDatas("wallet_new_bank_signup_imp")){let t=e.indexOf("retain_type_recommend_sms");-1!==t&&e.splice(t,1)}if(e.length>0){let i="0"
i=b?"2":p?"3":"4"
for(let a=0;a<e.length;a++){let r=e[a],_=u?t.input_pwd_retain_info:t.unput_pwd_retain_info,s=u?t.unput_pwd_retain_info:t.input_pwd_retain_info
if(_.includes(r))return n.constructRetJsonStr(u?"input_pwd_retain_info":"unput_pwd_retain_info",r,i,c)
if(s.includes(r))return n.constructRetJsonStr(u?"unput_pwd_retain_info":"input_pwd_retain_info",r,i,c)}}}if(!n.hasEventInOnePayDatas("wallet_password_verify_recommend_click")){let e=ntvModule.kvStorageRead(JSON.stringify(["marketPreferStatus"]))
if("1"===(void 0!==e?JSON.parse(e):{}).marketPreferStatus){ntvModule.kvStorageWrite(JSON.stringify({marketPreferStatus:"0"}))
let e=["retain_type_expand","retain_type_voucher"]
for(let i=0;i<e.length;i++){let a=e[i],r=u?t.input_pwd_retain_info:t.unput_pwd_retain_info,_=u?t.unput_pwd_retain_info:t.input_pwd_retain_info
if(r.includes(a))return n.constructRetJsonStr(u?"input_pwd_retain_info":"unput_pwd_retain_info",a,"5",c)
if(_.includes(a))return n.constructRetJsonStr(u?"unput_pwd_retain_info":"input_pwd_retain_info",a,"5",c)}}}let D=n.getEventDatasByName("wallet_password_verify_page_click"),S=n.getEventDatasByName("wallet_cashier_choose_method_click")
if(0!==D.length){let e=!1
for(let t=0;t<D.length;t++){if("5"===D[t][1].button_name){e=!0
break}}let i=!1
for(let e=0;e<S.length;e++){if("退出"!==S[e][1].button_name){i=!0
break}}if(e&&!i){let e="retain_type_other_pay_type",i=u?t.input_pwd_retain_info:t.unput_pwd_retain_info,a=u?t.unput_pwd_retain_info:t.input_pwd_retain_info
if(i.includes(e))return n.constructRetJsonStr(u?"input_pwd_retain_info":"unput_pwd_retain_info",e,"6",c)
if(a.includes(e))return n.constructRetJsonStr(u?"unput_pwd_retain_info":"input_pwd_retain_info",e,"6",c)}}if("verify_password"===i){let e=u?t.input_pwd_retain_info:t.unput_pwd_retain_info
if(0===e.length)return""
{let t=d?n.firstRetainTypeExcludeTypes(e,[...n.checkedVerifyTypes(),...n.marketingRetainTypes]):n.firstRetainTypeExcludeTypes(e,n.checkedVerifyTypes()),i=d?"1":"0"
return n.constructRetJsonStr(u?"input_pwd_retain_info":"unput_pwd_retain_info",t,i,c)}}if("bio_verify"===i||"face_verify"===i||"sms_verify"===i){let e=t.verify_retain_info
if(0===e.length)return""
{let t=d?n.firstRetainTypeExcludeTypes(e,[...n.checkedVerifyTypes(),...n.marketingRetainTypes]):n.firstRetainTypeExcludeTypes(e,n.checkedVerifyTypes()),i=d?"1":"0"
return n.constructRetJsonStr("verify_retain_info",t,i,c)}}return""},processRetainInfoBatchData:function(e,t){let i=e.asset_meta_info
if(void 0===i||void 0===i.fund_bill_index)return e
let n=i.fund_bill_index
return e.retain_info_batch.input_pwd_retain_info=this.processRetainInfos(e.retain_info_batch.input_pwd_retain_info,n,t),e.retain_info_batch.unput_pwd_retain_info=this.processRetainInfos(e.retain_info_batch.unput_pwd_retain_info,n,t),e.retain_info_batch.verify_retain_info=this.processRetainInfos(e.retain_info_batch.verify_retain_info,n,t),e},processRetainInfos:function(e,t,i){var n=[]
if(!e||!Array.isArray(e))return n
for(let a=0;a<e.length;a++){let r=e[a],_=this.processOneRetainInfo(r,t,i)
n.push(_)}return n},processOneRetainInfo:function(e,t,i){if("retain_type_questionnaire"===e.type){let r=e.questionnaire_retain_info
if(void 0!==r&&void 0!==r.content_group_list){let e=r.content_group_list
for(let r=0;r<e.length;r++){let _=e[r]
var n=_.content_list
if(void 0!==n&&n.length>0){var a=[]
for(let e=0;e<n.length;e++){let r=n[e],_=r.rule,s=!0
if(void 0===_||0===_.length)s=!0
else for(let e=0;e<_.length;e++){let n=_[e],a=JSON.parse(n)
if(void 0!==a.verify_whitelist){let e=a.verify_whitelist
if(void 0!==i&&i.length>0)for(let t=0;t<i.length;t++){let n=i[t],a=e.indexOf(n)
if(-1!==a){s=!0
break}if(-1===a&&t===i.length-1){s=!1
break}}}if(void 0!==a.fund_bill_index_whitelist){let e=a.fund_bill_index_whitelist
if(void 0!==t){if(-1===e.indexOf(t)){s=!1
break}}}if(void 0!==a.fund_bill_index_blacklist){let e=a.fund_bill_index_blacklist
if(void 0!==t){if(-1!==e.indexOf(t)){s=!1
break}}}}s&&a.push(r)}_.content_list=a}}}}return e},getValidRetainInfo:function(e,t){var i=[],n=[]
"input_pwd_retain_info"===t?(i=e.input_pwd_retain_info,n=e.retain_info_batch.input_pwd_retain_info):"unput_pwd_retain_info"===t?(i=e.unput_pwd_retain_info,n=e.retain_info_batch.unput_pwd_retain_info):"verify_retain_info"===t&&(i=e.verify_retain_info,n=e.retain_info_batch.verify_retain_info)
var a=[]
for(let t=0;t<i.length;t++){let r=i[t]
if(void 0!==n)for(let t=0;t<n.length;t++){let i=n[t]
i.type===r&&!1===this.checkRetainInfoValidation(e,i)&&a.push(r)}}for(let e=0;e<a.length;e++){let t=i.indexOf(a[e]);-1!==t&&i.splice(t,1)}return i},checkRetainInfoValidation:function(e,t){return!1!==this.checkRetainInfoAssetMatchValidation(e,t)&&!1!==this.checkRetainInfoTypeValidation(e,t)},checkRetainInfoAssetMatchValidation:function(e,t){var i=t.asset_match_rule
if(null==i||0===i.length)return!0
var n=e.asset_meta_info
for(let e=0;e<i.length;e++){let t=i[e],a=!0
if(a=a&&(void 0===t.asset_id||0===t.asset_id.length||t.asset_id===n.asset_id),a=a&&(void 0===t.asset_type||0===t.asset_type.length||t.asset_type===n.asset_type),a=a&&(void 0===t.instid||0===t.instid.length||t.instid===n.instid),a=a&&(void 0===t.asset_type_code||0===t.asset_type_code.length||t.asset_type_code===n.asset_type_code),!0===a)return!0}return!1},checkRetainInfoTypeValidation:function(e,t){var i=t.is_combine_filter,n="1"===e.is_combine_pay
if(i&&i.length>0&&n&&"true"===i)return!1
if("retain_type_balance_combine"===t.type&&n)return!1
if("retain_type_reset_pwd"===t.type){var a="verify_pwd"===e.pwd_type,r="verify_password"===e.from_scene
return a&&r}return!0},onTrackEvent:function(e,t){if(-1!==this.concernedEvents.indexOf(e))if("wallet_rd_exit_doupay_process"!==e)if("wallet_exit_cashier_process"!==e){"wallet_password_verify_recommend_click"===e&&ntvModule.kvStorageWrite(JSON.stringify({marketPreferStatus:"1"}))
var i,n=[]
if(n.push(e),t.length>0)try{i=JSON.parse(t)}catch(e){i={}}else i={}
n.push(i),this.onePayEventDatas.push(n)}else this.onePayEventDatas=[]
else this.onePayEventDatas=[]},decideAvailableWndType(e){try{const t=JSON.parse(e),{growth_model:i,is_bio_degrade:n,is_support_bio:a,primary_category:r,asset_meta_info:_,asset_to_combine_asset_meta_info:s,current_verify_type:o}=t
if(!i)return""
const l=this.initDecisionState(i,o)
return"function"==typeof logFunction&&(logFunction("输入的弹窗顺序:"+l.viewModels.map((e=>e.sub_type)).join(",")),logFunction("输入的参数:"+JSON.stringify({is_bio_degrade:n,is_support_bio:a,primary_category:r,asset_meta_info:_,current_verify_type:o})),logFunction("是否选择过月付:"+l.isSelectYueFu),logFunction("是否选择过余额:"+l.isSelectBalance),logFunction("是否有生物验证曝光:"+l.bioImpressions.isBioImp),logFunction("是否有活体验证曝光:"+l.bioImpressions.isLiveImp),logFunction("是否有短信验证曝光:"+l.bioImpressions.isSmsImp)),this.applyFilterChain(l,{isBioDegrade:"1"===n,isSupportBio:"1"===a,assetMeta:s||_,primaryCategory:r}),JSON.stringify(this.handleSpecialScenarios(l))}catch(e){return""}},verifyUnifyResult(e){const t=this.getLastEventByEventName(e)
if(t&&t[1])switch(String(t[1].result)){case"1":return 1
case"0":return 0
default:return}},hasSelectMethod:function(e){return this.onePayEventDatas.some((function(t){const i=t[0],n=t[1]||{},a="wallet_cashier_second_pay_page_click"===i&&"choose_method_click"===n.click||"wallet_cashier_choose_method_click"===i
return e?a&&n.method&&n.method.includes(e):a}))},getLastEventByEventName:function(e){const t=this.onePayEventDatas.filter((function(t){return t[0]===e}))
return t.length?t[t.length-1]:void 0},removeArrayByValue:(e,t)=>e.filter((e=>e!==t)),sortArrayByTypeAndSubType(e,t,i){const[n,a]=e.reduce((([e,i],n)=>n.type===t?[[...e,n],i]:[e,[...i,n]]),[[],[]]),r=new Map
i.forEach(((e,t)=>{r.set(e,t)}))
const _=n.filter((e=>r.has(e.sub_type)))
_.sort(((e,t)=>r.get(e.sub_type)-r.get(t.sub_type)))
let s=0
return[...n.map((e=>r.has(e.sub_type)?_[s++]:e)),...a]},getPriorLynxSchema:e=>e&&e.Exts?e.Exts.prior_lynx_schema:void 0,getViewModelMaterial:e=>e&&e.global?e.global.material:void 0,constructRetainDecision(e,t,i){t.growthModel.view_model_list=void 0,i?t.ruleId=i:t.ruleId||(t.ruleId="0")
return e?{rule_id:t.ruleId,growth_view_model:{...t.growthModel,view_model:e},sub_type:e.sub_type,contact_retain_info:this.buildRetainInfo(e,t.isRetainAvailable,t.unvailableReasons.join("、"),t.ruleId),prior_lynx_schema:this.getPriorLynxSchema(e),material:this.getViewModelMaterial(e)}:{rule_id:"-1",is_client_decision:"0"}},buildRetainInfo(e,t,i,n){const{global:a}=e,r={...this.extractCommonParams(a?.common_params),rule_id:n,rule_msg:"js挽留规则",is_client_decision:"1",is_retain_available:t?"1":"0"}
return t||(r.retain_unvailable_reason_msg=i),JSON.stringify(r)},extractCommonParams:e=>["contact_id","contact_name","retain_template_id","retain_template_name","retain_type_id","retain_type_name"].reduce(((t,i)=>(e?.[i]&&(t[i]=e[i]),t)),{}),initDecisionState(e,t){return{viewModels:[...e.view_model_list],isRetainAvailable:!0,unvailableReasons:[],growthModel:e,isSelectYueFu:this.hasSelectMethod("YUEFU"),isSelectBalance:this.hasSelectMethod("DOUPAYACCOUNT"),bioImpressions:{isBioImp:this.hasEventInOnePayDatas("wallet_fingerprint_verify_page_imp")||"1"===t||"2"===t||0==this.hasFingerToPwd(),isLiveImp:this.hasEventInOnePayDatas("wallet_alivecheck_fullpage_imp")||this.hasEventInOnePayDatas("wallet_alivecheck_call"),isSmsImp:this.hasEventInOnePayDatas("wallet_new_bank_signup_imp")||this.hasEventInOnePayDatas("wallet_sms_check_halfscreen_page_imp")||"8"===t}}},applyFilterChain(e,t){[this.filterByBioDegrade.bind(this),this.filterByBioSupport.bind(this),this.filterByServerRules.bind(this),this.filterPaymentSwitchPopups.bind(this)].forEach((i=>i(e,t)))},filterByBioDegrade:function(e,t){const i=this
e.viewModels=e.viewModels.filter((function(n){const a=["ChangeEnabledFaceID","ChangeEnabledFinger"].includes(n.sub_type)
return!t.isBioDegrade||!a||(i.recordUnavailable(e,"因[生物不可用]规则校验排除展示"),i.debugLog("过滤候选[生物降级]",{candidate:i.getViewModelDebugName(n),reason:"因[生物不可用]规则校验排除展示"}),!1)}))},filterByBioSupport(e,t){e.viewModels=e.viewModels.filter((i=>{const n=["ChangeDisabledFaceID","ChangeDisabledFinger"].includes(i.sub_type)
return!(!t.isSupportBio&&n)||(this.recordUnavailable(e,"因[设备不支持生物]规则校验排除展示"),"function"==typeof logFunction&&logFunction("因[设备不支持生物]规则校验排除展示:"+i.sub_type),!1)}))},checkServerRule(e,t){const{pay_channel_whitelist:i,fund_list_index_whitelist:n,fund_list_index_blacklist:a,support_bio_open_status:r}=e,_=t.assetMeta&&t.assetMeta.fund_bill_index
if(i&&!i.includes(t.primaryCategory))return"function"==typeof logFunction&&logFunction("因[支付渠道白名单]规则校验排除展示:"+t.primaryCategory),!1
if(n&&!n.includes(_))return"function"==typeof logFunction&&logFunction("因[资金索引白名单]规则校验排除展示:fundIndex "+_),!1
if(a&&a.includes(_))return"function"==typeof logFunction&&logFunction("因[资金索引黑名单]规则校验排除展示:fundIndex "+_),!1
if(r){if(t.isBioDegrade&&r.includes("1")||!t.isSupportBio&&r.includes("0"))return"function"==typeof logFunction&&logFunction("因[生物支持状态]规则校验排除展示:support_bio_open_status "+r.join(",")),!1}return!0},filterByServerRules(e,t){const i=e=>this.checkServerRule(JSON.parse(e),t)
e.viewModels=e.viewModels.filter((e=>{if(!e.global||!e.global.rule_config||0===e.global.rule_config.length)return!0
const t=e.global.rule_config.every(i)
return"function"!=typeof logFunction||t||logFunction("因[服务端规则]校验排除展示:"+e.sub_type),t}))},filterPaymentSwitchPopups:function(e){const t=this
e.viewModels=e.viewModels.filter((function(i){const n="ChangeUseCreditPay"===i.sub_type,a=["ChangeBalanceCombinePay","ChangeBalance"].includes(i.sub_type)
return e.isSelectYueFu&&n?(t.recordUnavailable(e,"因[月付支付]规则校验排除展示"),t.debugLog("过滤候选[已选支付方式]",{candidate:t.getViewModelDebugName(i),reason:"当前已选择过月付，过滤切换月付候选"}),!1):!e.isSelectBalance||!a||(t.recordUnavailable(e,"因[余额支付]规则校验排除展示"),t.debugLog("过滤候选[已选支付方式]",{candidate:t.getViewModelDebugName(i),reason:"当前已选择过余额，过滤切换余额候选"}),!1)}))},shouldHandleVerification(e){const{pwd_verify_result:t,bio_verify_result:i,face_verify_result:n,sms_verify_result:a}=this.getVerifyResults()
let r=this.hasVerificationFailed(t,i,n,a)
return r?(e.ruleId="2","function"==typeof logFunction&&logFunction("因[验证失败]规则提升切换核身方式挽留的优先级"),!0):(r=this.hasEventInOnePayDatas("wallet_cashier_right_click"),r?(e.ruleId="3","function"==typeof logFunction&&logFunction("因[点击过右上角]规则提升切换核身方式挽留的优先级"),!0):(r=this.hasEventInOnePayDatas("wallet_password_verify_page_forget_click"),r?(e.ruleId="4","function"==typeof logFunction&&logFunction("因[点击过忘记密码]规则提升切换核身方式挽留的优先级"),!0):(r=0==this.hasFingerToPwd(),!!r&&(e.ruleId="1","function"==typeof logFunction&&logFunction("因[指纹过切换到密码]规则提升切换核身方式挽留的优先级"),!0))))},hasFingerToPwd(){if(this.hasEventInOnePayDatas("wallet_fingerprint_verify_page_to_pwd"))return 0},getVerifyResults(){return{pwd_verify_result:this.verifyUnifyResult("wallet_password_verify_page_verify_result"),bio_verify_result:this.verifyUnifyResult("wallet_fingerprint_verify_page_verify_result"),face_verify_result:this.verifyUnifyResult("wallet_alivecheck_result"),sms_verify_result:this.verifyUnifyResult("wallet_new_bank_signup_result")}},hasVerificationFailed:(...e)=>e.some((e=>0===e)),shouldHandlePaymentMethod(e){const t=this.onePayEventDatas.some((([e,t])=>"wallet_cashier_second_pay_page_click"===e&&"more_method_click"===t.click||"wallet_cashier_more_method_click"===e))&&!this.hasSelectMethod()&&e.viewModels.some((e=>"ChangePaymentMethod"===e.type))
return"function"==typeof logFunction&&t&&logFunction("因[点击过更多，但是没有切换过渠道]规则提升渠道切换的优先级"),t},getDefaultResponse:e=>(e.unvailableReasons.push("无可用挽留弹窗"),{rule_id:"-1",is_client_decision:"0",growth_view_model:void 0,contact_retain_info:JSON.stringify({rule_id:"-1",is_client_decision:"0",is_retain_available:"0",retain_unvailable_reason_msg:e.unvailableReasons.join("、")})}),handleSpecialScenarios(e){if(this.shouldHandleVerification(e)){const t=this.handleVerificationScenario(e)
if(t)return t}if(this.shouldHandlePaymentMethod(e)){const t=this.handlePaymentMethodScenario(e)
if(t)return t}return"function"==typeof logFunction&&logFunction("返回服务端下发的第一个有效弹窗"),e.viewModels.length>0?this.constructRetainDecision(e.viewModels[0],e):this.getDefaultResponse(e)},checkImpressedType(e,t){const i={ChangeDisabledFaceID:"isBioImp",ChangeDisabledFinger:"isBioImp",ChangeEnabledFaceID:"isBioImp",ChangeEnabledFinger:"isBioImp",ChangeLive:"isLiveImp",ChangeSMS:"isSmsImp"}[e]
return!!i&&t[i]},sortArrayByRightButtonImpression(e){const t=this.getLastEventByEventName("wallet_cashier_right_button_show")
if(!t||!t[1]||!t[1].button_name)return e
const i=Object.entries({"面容":["ChangeEnabledFaceID","ChangeDisabledFaceID"],"指纹":["ChangeEnabledFinger","ChangeDisabledFinger"],"刷脸":["ChangeLive"],"短信":["ChangeSMS"]}).find((([e])=>t[1].button_name.includes(e)))
return i?[...e.filter((e=>!i[1].includes(e))),...e.filter((e=>i[1].includes(e)))]:e},handleVerificationScenario(e){let t=["ChangeDisabledFaceID","ChangeDisabledFinger","ChangeEnabledFaceID","ChangeEnabledFinger","ChangeLive","ChangeSMS"].filter((t=>{const i=this.checkImpressedType(t,e.bioImpressions)
return e.viewModels=e.viewModels.filter((n=>!i||"ChangeVerifyMethod"!==n.type||n.sub_type!==t||(this.recordUnavailable(e,"因[核身曝光]规则校验排除展示"),"function"==typeof logFunction&&logFunction("因[核身曝光]规则校验排除展示:"+t),!1))),!i}))
t=this.sortArrayByRightButtonImpression(t),e.viewModels=this.sortArrayByTypeAndSubType(e.viewModels,"ChangeVerifyMethod",t),"function"==typeof logFunction&&logFunction("调整切换核验方式弹窗的排序为:"+e.viewModels.filter((e=>"ChangeVerifyMethod"===e.type)).map((e=>e.sub_type)).join(","))
const i=e.viewModels.find((e=>"ChangeVerifyMethod"===e.type))
if(i)return this.constructRetainDecision(i,e)
e.ruleId="0"},handlePaymentMethodScenario(e){const t=e.viewModels.find((e=>"ChangePaymentMethod"===e.type))
return t?this.constructRetainDecision(t,e,6):void 0},recordUnavailable:function(e,t){e.isRetainAvailable=!1,e.unvailableReasons.push(t)},genRetainInfo:function(e,t,i){let n
if(void 0!==i&&("input_pwd_retain_info"===e?n=i.input_pwd_retain_info:"unput_pwd_retain_info"===e?n=i.unput_pwd_retain_info:"verify_retain_info"===e&&(n=i.verify_retain_info)),void 0!==n)for(let e=0;e<n.length;e++){let i=n[e]
if(void 0!==i&&i.type===t)return i}},debugLog:function(e,t){},getViewModelDebugName:function(e){if(!e)return"unknown"
return(e.type||"UnknownType")+"/"+(e.sub_type||"UnknownSubType")+(e.material_no?"#"+e.material_no:"")},getViewModelDebugList:function(e){const t=this
return(e||[]).map((function(e){return t.getViewModelDebugName(e)}))},logFilterResult:function(e,t,i){const n=this.getViewModelDebugList(i),a=this.getViewModelDebugList(e.viewModels),r=n.filter((function(e){return-1===a.indexOf(e)}))
this.debugLog("过滤链["+t+"]执行完成",{before:n,after:a,removed:r})},initStdWithUnifyFilterDecisionState:function(e,t){return{viewModels:[].concat(e.view_model_list||[]),isRetainAvailable:!0,unvailableReasons:[],growthModel:e,isSelectYueFu:this.hasSelectMethod("YUEFU"),isSelectBalance:this.hasSelectMethod("DOUPAYACCOUNT"),currentVerifyType:t}},applyStdWithUnifyFilterChain:function(e,t){const i=this,n=[{name:"生物降级",handler:this.filterByBioDegrade.bind(this)},{name:"设备生物能力",handler:this.filterStdWithUnifyBioSupport.bind(this)},{name:"服务端规则",handler:this.filterStdWithUnifyServerRules.bind(this)},{name:"已选支付方式",handler:this.filterPaymentSwitchPopups.bind(this)}]
this.debugLog("过滤链开始",{params:t,candidates:this.getViewModelDebugList(e.viewModels)}),n.forEach((function(n){const a=[].concat(e.viewModels||[])
n.handler(e,t),i.logFilterResult(e,n.name,a)})),this.debugLog("过滤链结束",{isRetainAvailable:e.isRetainAvailable,unvailableReasons:e.unvailableReasons,candidates:this.getViewModelDebugList(e.viewModels)})},filterStdWithUnifyBioSupport:function(e,t){const i=this
e.viewModels=e.viewModels.filter((function(n){const a=n.sub_type||"",r=0===a.indexOf("ChangeDisabledFaceID")||0===a.indexOf("ChangeDisabledFinger")
return!(!t.isSupportBio&&r)||(i.recordUnavailable(e,"因[设备不支持生物]规则校验排除展示"),i.debugLog("过滤候选[设备生物能力]",{candidate:i.getViewModelDebugName(n),reason:"因[设备不支持生物]规则校验排除展示"}),!1)}))},explainServerRule:function(e,t){const i=e.pay_channel_whitelist,n=e.fund_list_index_whitelist,a=e.fund_list_index_blacklist,r=e.support_bio_open_status,_=t.assetMeta&&t.assetMeta.fund_bill_index
if(i&&!i.includes(t.primaryCategory))return{passed:!1,reason:"支付渠道不在白名单内",rule:e}
if(n&&!n.includes(_))return{passed:!1,reason:"资金位不在白名单内",rule:e}
if(a&&a.includes(_))return{passed:!1,reason:"资金位命中黑名单",rule:e}
if(r){if(t.isBioDegrade&&r.includes("1")||!t.isSupportBio&&r.includes("0"))return{passed:!1,reason:"命中生物状态限制",rule:e}}return{passed:!0}},checkStdWithUnifyServerRule:function(e,t){return this.explainServerRule(e,t).passed},filterStdWithUnifyServerRules:function(e,t){const i=this
e.viewModels=e.viewModels.filter((function(n){if(!n.global||!n.global.rule_config||0===n.global.rule_config.length)return i.debugLog("过滤候选[服务端规则]保留",{candidate:i.getViewModelDebugName(n),reason:"未配置rule_config"}),!0
for(let a=0;a<n.global.rule_config.length;a++){const r=n.global.rule_config[a]
let _
try{_=JSON.parse(r)}catch(t){return i.recordUnavailable(e,"因[服务端规则格式异常]规则校验排除展示"),i.debugLog("过滤候选[服务端规则]",{candidate:i.getViewModelDebugName(n),reason:"rule_config JSON 解析失败",rawRule:r}),!1}const s=i.explainServerRule(_,t)
if(!s.passed)return i.recordUnavailable(e,"因[服务端规则]规则校验排除展示"),i.debugLog("过滤候选[服务端规则]",{candidate:i.getViewModelDebugName(n),reason:s.reason,rule:_,params:t}),!1
i.debugLog("服务端规则校验通过",{candidate:i.getViewModelDebugName(n),rule:_})}return!0}))},mapSubTypeToStandardRetainType:function(e){const t=e.sub_type,i=e.type
return"ChangeResetPwd"===t?"retain_type_reset_pwd":"ChangePwd"===t?"retain_type_recommend_pwd":"ChangeEnabledFaceID"===t||t&&0===t.indexOf("ChangeDisabledFaceID")?"retain_type_recommend_faceid":"ChangeEnabledFinger"===t||t&&0===t.indexOf("ChangeDisabledFinger")?"retain_type_recommend_finger":"ChangeLive"===t?"retain_type_recommend_face":"ChangeSMS"===t?"retain_type_recommend_sms":"ChangeBalance"===t?"retain_type_balance":"ChangeBalanceCombinePay"===t?"retain_type_balance_combine":t&&-1!==t.indexOf("Expand")?"retain_type_expand":"LifeDiscount"===t||t&&-1!==t.indexOf("LifePromotion")?"retain_type_life_promotion":"EcomLabel"===t||"Label"===t||t&&-1!==t.indexOf("GoodsLabel")?"retain_type_goods_label":"ChangePaymentMethod"===i?"retain_type_other_pay_type":"Marketing"===i?"retain_type_voucher":"retain_type_default"},getLifePromotionExtraData:function(){return{params_for_special:"tppp",is_chaselight:"1",keep_pop_type:"shengfu_202508",business:"生服弹窗验证组件",pop_style:"retain_type_goods"}},enrichLifePromotionResponse:function(e,t){if(!e||!t)return e
return"retain_type_life_promotion"!==this.mapSubTypeToStandardRetainType(t)||(e.retain_info_data=t,e.extra_data=this.getLifePromotionExtraData()),e},firstNotExcluded:function(e,t){if(e&&0!==e.length){if(!t||0===t.length)return e[0]
for(let i=0;i<e.length;i++)if(!t.includes(e[i]))return e[i]}},decideOnCandidates:function(e,t,i){const n=this
if(!e||0===e.length)return void this.debugLog("主决策终止","过滤后无候选 retain_type")
const a=function(t){return-1!==e.indexOf(t)},r=function(e,i){const a=t[e]
if(a)return n.debugLog("主决策命中",{ruleId:i,retainType:e,candidate:n.getViewModelDebugName(a)}),{viewModel:a,ruleId:i}
n.debugLog("主决策命中失败",{ruleId:i,retainType:e,reason:"retainTypeToVm 中不存在对应 viewModel"})},_=String(i.current_verify_type)
let s
if(s="5"===_?"face_verify":"8"===_?"sms_verify":"1"===_||"2"===_?"bio_verify":"skip_pwd"===_?"skip_pwd":"verify_password",this.debugLog("主决策开始",{fromScene:s,currentVerifyType:_,candidates:e,checkedVerifyTypes:this.checkedVerifyTypes()}),"skip_pwd"===s)return this.debugLog("规则[免密首个候选]命中",{reason:"当前 fromScene=skip_pwd，直接返回首个候选",candidate:e[0]}),r(e[0],"0")
if(n.hasEventInOnePayDatas("wallet_rd_yuefu_auth_expand")&&a("retain_type_default"))return this.debugLog("规则[月付授信膨胀优先default]命中","检测到 wallet_rd_yuefu_auth_expand 且候选中存在 retain_type_default"),r("retain_type_default","0")
const o=n.hasEventInOnePayDatas("wallet_rd_default_method_changed")
if(this.debugLog("主决策上下文",{changedPayMethod:o,currentVerifyType:_}),"bio_verify"===s||"face_verify"===s||"sms_verify"===s){const t=n.hasEventInOnePayDatas("wallet_password_verify_page_imp"),i=n.hasEventInOnePayDatas("wallet_sms_check_halfscreen_page_imp")||n.hasEventInOnePayDatas("wallet_new_bank_signup_imp"),a=n.hasEventInOnePayDatas("wallet_fingerprint_verify_page_imp"),_=n.hasEventInOnePayDatas("wallet_alivecheck_fullpage_imp")||n.hasEventInOnePayDatas("wallet_alivecheck_call"),l=(t?1:0)+(i?1:0)+(a?1:0)+(_?1:0)
if(n.debugLog("规则[加验未提交结果]检查",{fromScene:s,impCount:l,pwdImp:t,smsImp:i,fingerImp:a,liveImp:_}),l>1){const t="face_verify"===s?n.verifyResult("wallet_alivecheck_result"):void 0!==n.verifyResult("wallet_sms_check_halfscreen_result")?n.verifyResult("wallet_sms_check_halfscreen_result"):n.verifyResult("wallet_new_bank_signup_result")
if(void 0===t){const i=n.firstNotExcluded(e,n.checkedVerifyTypes())
return n.debugLog("规则[加验未提交结果]命中",{verifyResult:t,pickedRetainType:i,ruleId:o?"1":"0"}),i?r(i,o?"1":"0"):void 0}n.debugLog("规则[加验未提交结果]未命中",{reason:"当前验证方式已有结果",verifyResult:t})}}const l=n.hasEventInOnePayDatas("wallet_password_verify_page_right_click"),c=n.hasEventInOnePayDatas("wallet_password_verify_page_forget_click")||n.hasEventInOnePayDatas("wallet_modify_password_forget_click"),u=n.hasEventInOnePayDatas("wallet_password_verify_page_first_input"),d=n.verifyResult("wallet_password_verify_page_verify_result"),p=n.verifyResult("wallet_fingerprint_verify_page_verify_result"),f=n.verifyResult("wallet_alivecheck_result"),y=void 0!==n.verifyResult("wallet_sms_check_halfscreen_result")?n.verifyResult("wallet_sms_check_halfscreen_result"):n.verifyResult("wallet_new_bank_signup_result"),h=0===d||0===p||0===f||0===y
if(this.debugLog("主决策验证结果",{switchVerifyBtnClked:l,fgtPwdClked:c,hasInputPwd:u,pwdVR:d,bioVR:p,faceVR:f,smsVR:y,verifyFailed:h}),"verify_password"===s&&(0===d||c||u)&&a("retain_type_reset_pwd"))return this.debugLog("规则[密码场景改密]命中",{fromScene:s,pwdVR:d,fgtPwdClked:c,hasInputPwd:u}),r("retain_type_reset_pwd","0")
let g=h||l||c||u
if(void 0!==ntvModule&&"1"===ntvModule.getABTestValAndExposure("cjpay_client_decision_algorithm_opt_7.3.7")&&(g=h||l||c),g){let e=["retain_type_recommend_faceid","retain_type_recommend_finger","retain_type_recommend_face","retain_type_recommend_sms"]
const t=n.getEventDatasByName("wallet_password_verify_page_imp")[0],_=t&&t[1]&&t[1].show_verify_type
if(_){const t=function(t,i){if(i.some((function(e){return _.includes(e)}))){const i=e.indexOf(t);-1!==i&&(e.splice(i,1),e.push(t))}}
t("retain_type_recommend_faceid",["面容支付","使用面容"]),t("retain_type_recommend_finger",["指纹支付","使用指纹"]),t("retain_type_recommend_face",["刷脸支付","使用刷脸"]),t("retain_type_recommend_sms",["使用短信","短信验证支付"])}const s="1"===i.is_bio_degrade,o=function(t){const i=e.indexOf(t);-1!==i&&e.splice(i,1)};(n.hasEventInOnePayDatas("wallet_fingerprint_verify_page_imp")||s)&&(-1!==e.indexOf("retain_type_recommend_faceid")?o("retain_type_recommend_faceid"):o("retain_type_recommend_finger")),(n.hasEventInOnePayDatas("wallet_alivecheck_fullpage_imp")||n.hasEventInOnePayDatas("wallet_alivecheck_call"))&&o("retain_type_recommend_face"),(n.hasEventInOnePayDatas("wallet_sms_check_halfscreen_page_imp")||n.hasEventInOnePayDatas("wallet_new_bank_signup_imp"))&&o("retain_type_recommend_sms")
const c=h?"2":l?"3":"4"
this.debugLog("规则[切换核身方式]候选顺序",{ruleId:c,needRecVerifyRetain:g,order:e})
for(let t=0;t<e.length;t++)if(a(e[t]))return r(e[t],c)
this.debugLog("规则[切换核身方式]未命中","排序后的核身方式类型均不在候选列表中")}if(this.debugLog("规则[切换核身方式]跳过",{needRecVerifyRetain:g}),n.hasEventInOnePayDatas("wallet_password_verify_recommend_click"))this.debugLog("规则[营销偏好]跳过","本次已经点击 wallet_password_verify_recommend_click")
else{const e=void 0!==ntvModule?ntvModule.kvStorageRead(JSON.stringify(["marketPreferStatus"])):void 0,t=e?JSON.parse(e):{}
if("1"===t.marketPreferStatus){void 0!==ntvModule&&ntvModule.kvStorageWrite(JSON.stringify({marketPreferStatus:"0"}))
const e=["retain_type_expand","retain_type_voucher"]
this.debugLog("规则[营销偏好]检查",{marketPreferStatus:t.marketPreferStatus,candidates:e})
for(let t=0;t<e.length;t++)if(a(e[t]))return r(e[t],"5")
this.debugLog("规则[营销偏好]未命中","本地偏好为1，但当前候选中无营销类型")}}const v=n.getEventDatasByName("wallet_password_verify_page_click")
if(v.length>0){const e=v.some((function(e){return"5"===e[1].button_name})),t=n.getEventDatasByName("wallet_cashier_choose_method_click").some((function(e){return"退出"!==e[1].button_name}))
if(e&&!t&&a("retain_type_other_pay_type"))return this.debugLog("规则[切换支付方式意向]命中",{hasClkSwitchPayMethod:e,hasChoosedPayMethod:t}),r("retain_type_other_pay_type","6")
this.debugLog("规则[切换支付方式意向]未命中",{hasClkSwitchPayMethod:e,hasChoosedPayMethod:t,hasOtherPayType:a("retain_type_other_pay_type")})}const w=n.firstNotExcluded(e,n.checkedVerifyTypes())
return this.debugLog("规则[兜底首个有效候选]",{pickedRetainType:w,ruleId:o?"1":"0"}),w?r(w,o?"1":"0"):void 0},decideStdWithUnifyFilterWndType:function(e){let t
try{t=JSON.parse(e)}catch(e){return""}if(!t.growth_model)return""
const i=this.initStdWithUnifyFilterDecisionState(t.growth_model,t.current_verify_type)
this.debugLog("入口开始",{currentVerifyType:t.current_verify_type,initialCandidates:this.getViewModelDebugList(i.viewModels)}),this.applyStdWithUnifyFilterChain(i,{isBioDegrade:"1"===t.is_bio_degrade,isSupportBio:"1"===t.is_support_bio,assetMeta:t.asset_to_combine_asset_meta_info||t.asset_meta_info,primaryCategory:t.primary_category})
const n=this,a=[],r={}
i.viewModels.forEach((function(e){const t=n.mapSubTypeToStandardRetainType(e);-1===a.indexOf(t)&&a.push(t),r[t]||(r[t]=e)})),this.debugLog("过滤后候选映射完成",{retainTypes:a,retainTypeToVm:Object.keys(r).reduce((function(e,t){return e[t]=n.getViewModelDebugName(r[t]),e}),{})})
const _=this.decideOnCandidates(a,r,t)
if(!_||!_.viewModel)return this.debugLog("入口返回兜底",{unvailableReasons:i.unvailableReasons}),JSON.stringify(this.getDefaultResponse(i))
const s=this.constructRetainDecision(_.viewModel,i,_.ruleId)
return this.debugLog("入口返回命中结果",{ruleId:_.ruleId,candidate:this.getViewModelDebugName(_.viewModel),subType:_.viewModel.sub_type}),JSON.stringify(this.enrichLifePromotionResponse(s,_.viewModel))}}
